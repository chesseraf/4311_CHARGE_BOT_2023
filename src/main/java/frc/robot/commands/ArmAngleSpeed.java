package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmAngleSpeed extends CommandBase{
       // Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

  private  double speedInit;
  private double speedFinal;
  private Arm arm;

  private double initAngle;
  private double currentAngle;
  private double targetAngle;
  private boolean movingOut;
  private boolean endStop;
  private double fracDone;
  
  public ArmAngleSpeed(Arm Arm, double TargetAngle, double SpeedInit,double SpeedFinal, boolean stopEnd) {
    arm = Arm;
    speedInit = SpeedInit;
    speedFinal = SpeedFinal;
    movingOut = SpeedInit>0;
    endStop = stopEnd;
    fracDone=0;
    
    currentAngle = arm.armTalon.getSelectedSensorPosition();
    targetAngle = TargetAngle;
    initAngle = arm.armTalon.getSelectedSensorPosition();

    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    fracDone = (currentAngle-initAngle)/(targetAngle-initAngle);
    arm.armTalon.set(fracDone*speedInit+(1-fracDone)*speedFinal);
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
