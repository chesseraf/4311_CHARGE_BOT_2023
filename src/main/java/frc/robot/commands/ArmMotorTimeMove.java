package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmMotorTimeMove extends CommandBase{

  private  double speed;
  private Arm arm;

  private double counter = 0;
  private double target = 0;
  
  public ArmMotorTimeMove(Arm Arm, double DriveTimeSec, double Speed) {
    arm = Arm;
    speed = Speed;
    target = DriveTimeSec * 50;    //50 cycles per second

    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arm.armTalon.set(speed);
    counter++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.armTalon.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(counter<target){
      return false;
    }
    else{
      return true;
    }
  }

}

