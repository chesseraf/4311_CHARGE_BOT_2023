package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmAngleMove extends CommandBase{
       // Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

  private  double speed;
  private Arm arm;

  private double currentAngle;
  private double targetAngle;
  private boolean movingOut;
  private boolean endStop;
  
  public ArmAngleMove(Arm Arm, double TargetAngle, double Speed, boolean stopEnd) {
    arm = Arm;
    speed = Speed;
    movingOut = speed>0;
    endStop = stopEnd;
    
    currentAngle = arm.armTalon.getSelectedSensorPosition();
    targetAngle = TargetAngle;

    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arm.armTalon.set(speed);
    currentAngle = arm.armTalon.getSelectedSensorPosition();
    //update current angle
}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if(endStop){
        arm.armTalon.set(0);
    }
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(movingOut){
        if(currentAngle>targetAngle){
            return true;
          }else{
            return false;
          }
    } else {
        if(currentAngle<targetAngle){
            return true;
          }else{
            return false;
          }
    }
    
  }

    
}
