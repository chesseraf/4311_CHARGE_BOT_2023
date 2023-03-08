package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class MotorTimeMove extends CommandBase{

    // Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

  private final double speed;
  private final WPI_TalonFX talon;

  private int counter = 0;
  private int target = 0;

  /** Creates a new driveForTime. */
  
  public  MotorTimeMove(WPI_TalonFX Talon, double driveTime, double speed) {
    this.speed = speed;
    this.talon = Talon;

    //50 cycles per second
    target = (int) (driveTime * 50);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    talon.set(speed);
    counter++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    talon.set(0);
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

