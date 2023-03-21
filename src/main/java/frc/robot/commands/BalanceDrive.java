package frc.robot.commands;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class BalanceDrive extends CommandBase {
  //CONSTANTS   angles are in degrees, *AngleForStartedGoingUp > AngleForSlowDown
  double AngleForStartedGoingUp = 20;
  double AngleForStop = 8;
  double InitSpeed = 0.6;
  double AngleForSlowDown = 15;
  double SlowSpeed = 0.25;
  double StartClimbSpeed  = 0.6;

  // variables
  DriveTrain driveTrain;
  AHRS gyro;

  double CurrentSpeed;
  double roll;
  double timer;
  double targTime;

  boolean ForwardPositiveSpeed;
  boolean GyroValPositive;
  boolean StartedGoingUp;
  boolean SlowDownBool;
  boolean end;

    public BalanceDrive(DriveTrain DriveTrain, AHRS Gyro, boolean WingsAreInFront, double MaxSeconds) {
      gyro = Gyro;
      driveTrain = DriveTrain;

      targTime = 50*MaxSeconds;
      ForwardPositiveSpeed = !WingsAreInFront;
      GyroValPositive = WingsAreInFront;
      
      addRequirements(driveTrain);
    }
    
      // Called when the command is initially scheduled.
      @Override
      public void initialize() {
        StartedGoingUp = false;
        end = false;
        SlowDownBool = false;
        timer=0;
      }
    
      // Called every time the scheduler runs while the command is scheduled.
      @Override
      public void execute() {
  /*
   * update bools
   * if roll>angleforstartgoingup --> startgoingup = true
   * if (startgoingup AND roll<angleforslowdown) --> slowdownbool = true
   * if (slowdownBool AND roll<stopAngle) --> end = true
   * 
   * plan
   * if !startedgoingup set initspeed
   * if !slowingdownbool set startclimbspeed
   * if !angleforstop set slowspeed
   * if end set 0, stops
   * 
   * then if !forwardPositive --> speed = -speed
   */
        roll = gyro.getRoll()-Robot.calibratedGyro;
        if(!GyroValPositive){
          roll = -roll;
        }
        timer++;  
        
        if(roll>AngleForStartedGoingUp){
          StartedGoingUp = true;
        }
        if(StartedGoingUp&& roll<AngleForSlowDown){
          SlowDownBool = true;
        }
        if(SlowDownBool&&roll<AngleForStop){
          end = true;
        }
        if(!StartedGoingUp){
          CurrentSpeed = InitSpeed;
        } else if(!SlowDownBool){
          CurrentSpeed = StartClimbSpeed;
        } else if(!end){
          CurrentSpeed = SlowSpeed;
        } else {
          CurrentSpeed = 0;
        }

        if(!ForwardPositiveSpeed){
          CurrentSpeed = -CurrentSpeed;
        }
        driveTrain.turnDrive(CurrentSpeed, 0);
      }
    


      // Called once the command ends or is interrupted.
      @Override
      public void end(boolean interrupted) {
         driveTrain.turnDrive(0, 0);
      }
    
      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        //return false;
        if(timer>targTime){
          System.out.println("ABalanceDrive.isFinished()");
          return true;

        } else {
          return false;
        }
        /*if(end){
          System.out.println("BBalanceDrive.isFinished()");

          return true;
        }else{
          return false;
        }
        */
        
      }
}