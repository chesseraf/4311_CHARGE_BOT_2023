package frc.robot.commands;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class BalanceDrive extends CommandBase {
  DriveTrain driveTrain;
  AHRS gyro;
  boolean ForwardPositiveSpeed;
  boolean StartedGoingUp = false;
  boolean SlowDownBool = false;
  boolean end = false;
  double AngleForStartedGoingUp = 20;
  double AngleForStop = 8;
  double InitSpeed = 0.6;
  double AngleForSlowDown = 15;
  double SlowSpeed = 0.25;
  double StartClimbSpeed  = 0.6;
  /*
   * update bools
   * if roll>angleforstartgoingup --> startgoingup = true
   * if (startgoingup AND roll<angleforslowdown) --> slowdownbool = true
   * if (slowdownBool AND roll<stopAngle) --> end = true
   * plan
   * if !startedgoingup set initspeed
   * if !slowingdownbool set startclimbspeed
   * if !angleforstop set slowspeed
   * if end set 0, stops
   * 
   * then if !forwardPositive --> speed = -speed
   */

  double CurrentSpeed;
  double roll;


    public BalanceDrive(DriveTrain DriveTrain, AHRS Gyro, boolean WingsAreInFront) {
        StartedGoingUp = false;
        end = false;
         SlowDownBool = false;

        gyro = Gyro;
        ForwardPositiveSpeed = !WingsAreInFront;
        driveTrain = DriveTrain;
        addRequirements(driveTrain);
      }
    
      // Called when the command is initially scheduled.
      @Override
      public void initialize() {
        Robot.timer = 0;
        for (int i = 0; i < 8; i++) {
          System.out.println("BalanceDrive.initialize()");
        }
        
        StartedGoingUp = false;
        end = false;
         SlowDownBool = false;

      }
    
      // Called every time the scheduler runs while the command is scheduled.
      @Override
      public void execute() {
        roll = gyro.getRoll();
        /*if(!ForwardPositiveSpeed){
          roll = -roll;
        }*/
  /*
   * update bools
   * if roll>angleforstartgoingup --> startgoingup = true
   * if (startgoingup AND roll<angleforslowdown) --> slowdownbool = true
   * if (slowdownBool AND roll<stopAngle) --> end = true
   * plan
   * if !startedgoingup set initspeed
   * if !slowingdownbool set startclimbspeed
   * if !angleforstop set slowspeed
   * if end set 0, stops
   * 
   * then if !forwardPositive --> speed = -speed
   */
        
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
        } else if(roll<AngleForSlowDown&&!SlowDownBool){
          CurrentSpeed = StartClimbSpeed;
        } else if(roll>AngleForStop&&SlowDownBool){
          CurrentSpeed = SlowSpeed;
        } else if(roll<AngleForStop&&SlowDownBool){
          CurrentSpeed = 0;
        } else if(end){
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
        if(Robot.timer>5000){
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