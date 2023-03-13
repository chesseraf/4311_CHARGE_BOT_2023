package frc.robot.commands;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class BalanceDrive extends CommandBase {
  DriveTrain driveTrain;
  Gyro gyro;
  boolean movingForward;
    public BalanceDrive(DriveTrain DriveTrain, Gyro Gyro) {
        gyro = Gyro;
        driveTrain = DriveTrain;
        addRequirements(driveTrain);
      }
      public static double angle;
      public static double rate;
    
      // Called when the command is initially scheduled.
      @Override
      public void initialize() {

      }
    
      // Called every time the scheduler runs while the command is scheduled.
      @Override
      public void execute() {
        angle = gyro.getAngle();
        rate = gyro.getRate();

        driveTrain.turnDrive(gyroDrive(angle,rate), 0);
      }
    
      private double gyroDrive(double angle, double rate) {
        if(Math.abs(angle)>Constants.MIN_GYRO_MOVE){
          if(angle>0){
            return(Constants.MIN_BALANCE_MOVE);
          }else{
            return(-Constants.MIN_BALANCE_MOVE);
          }
        } else {
          return 0;
        }
        /* 
        if(angle > 0.5 && rate > 0.1){

        } else if(angle < -0.5 && rate > 0.1){

        } else if(angle > 0.5 && rate < -0.1){

        } else if(angle < -0.5 && rate < -0.1){

        }
        */
        //return(angle/10);
      }

      // Called once the command ends or is interrupted.
      @Override
      public void end(boolean interrupted) {}
    
      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        if(RobotContainer.THRUSTMASTER.getRawButton(Constants.buttons.EXIT_BALANCE_DRIVE)){
            return(true);
        } else {
            return(false);
        }
      }
}