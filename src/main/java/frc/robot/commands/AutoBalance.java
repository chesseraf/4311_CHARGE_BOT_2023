package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import com.kauailabs.navx.frc.AHRS;

import frc.robot.Robot;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Wings;

public class AutoBalance extends SequentialCommandGroup{
  private Arm arm;
  public AutoBalance(DriveTrain driveTrain, Wings wings,Arm ARm, AHRS gyro) {
    arm = ARm;
    addRequirements(driveTrain);
    addRequirements(wings);
    addRequirements(arm);

    addCommands(
      new WingsExtend(wings)
      //.andThen(new DriveForTime(driveTrain,2, -0.4, 0))
      .andThen(new WaitCommand(1.2))
      .andThen(new ArmHighThrow(arm,wings,true))
      .andThen(new WaitCommand(0.2))
      .andThen(new ArmReturnInside(arm, wings))
      .andThen(new WaitCommand(0.4))
      .andThen(new WingsRetract(wings))
      /* 
      //NO MOBILITY
      .andThen(new BalanceDrive(driveTrain, gyro, true, (15-Robot.timer/50)))
       */

       /* */
       // MOBILITY 
      .andThen(new DriveForTime(driveTrain,4, -0.5, 0))
      .andThen(new DriveForTime(driveTrain, 2.7, 0.5, 0))
      .andThen(new BalanceDrive(driveTrain, gyro, false, (15-Robot.timer/50)))
                 
      //potentially add small drive back
    );
  }
}
