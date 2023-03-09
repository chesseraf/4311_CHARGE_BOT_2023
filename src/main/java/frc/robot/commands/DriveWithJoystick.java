package frc.robot.commands;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Wings;


public class DriveWithJoystick extends CommandBase{
  //public static double slowDown;
  private final DriveTrain driveTrain;

  private double XJoystick;
  private double YJoystick;

  private double speed;
  private double turnRate;

  public DriveWithJoystick(DriveTrain DriveTrain, Wings wings, Gyro gyro) {
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
        turnRate = (turnRate * turnRate) * (1-Constants.MIN_TURN) + Constants.MIN_TURN;
      } else {
        turnRate = -  XJoystick * XJoystick * (1-Constants.MIN_TURN) - Constants.MIN_TURN;
      }

      if(Math.abs(speed) < Constants.speedDeadBand){
        speed = 0;
        } else if ( speed > 0){
          speed = speed * speed * (1-Constants.MIN_POWER) + Constants.MIN_POWER;
        } else {
          speed = - speed * speed * (1-Constants.MIN_POWER) - Constants.MIN_POWER;
        }
      
      driveTrain.turnDrive(speed, turnRate );

  }// end of execute

  @Override
  public boolean isFinished() {
          return false;
      }
}