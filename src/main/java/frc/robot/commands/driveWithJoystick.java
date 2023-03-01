package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Wings;


public class driveWithJoystick extends CommandBase{
  //public static double slowDown;
  private final DriveTrain driveTrain;

  private double leftWheels = 0;
  private double rightWheels = 0;

  private double XJoystick;
  private double YJoystick;

  private double speed;
  private double turnRate;

  public static double LRfix(double LR){
  // double fin = LR;
    if(Math.abs(LR)<Constants.LRdeadband){
      return(0);
    } else if(LR>0){
      return(LR * LR * (1-Constants.minPower) + Constants.minPower);
    } else{
      return(-LR * LR * (1 - Constants.minPower) - Constants.minPower);
    }
  }
 

  public driveWithJoystick(DriveTrain DriveTrain, Wings wings, Gyro gyro) {
    driveTrain = DriveTrain;
    addRequirements(DriveTrain);
  }
  @Override
  public void initialize() {}
  @Override
  public void execute() {
    XJoystick = RobotContainer.joystickX;
    YJoystick = RobotContainer.joystickY;
    
  
    speed =   -YJoystick;
    turnRate = -XJoystick;

      if(Math.abs(turnRate) < Constants.turnDeadBand) {
        turnRate = 0;
      } else if (turnRate < 0) {
        turnRate = (turnRate * turnRate) * 0.85 + 0.15;
      } else {
        turnRate = -  XJoystick * XJoystick * 0.85 - 0.15;
      }

      if(Math.abs(speed) < Constants.speedDeadBand){
        speed = 0;
        } else if ( speed > 0){
          speed = speed * speed * 0.75 + 0.25;
        } else {
          speed = - speed * speed * 0.75 - 0.25;
        }
      
      driveTrain.turnDrive(-speed/2, turnRate );

  }// end of execute

  @Override
  public boolean isFinished() {
          return false;
      }
}