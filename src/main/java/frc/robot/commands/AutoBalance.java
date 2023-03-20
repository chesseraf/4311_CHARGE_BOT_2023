package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import com.kauailabs.navx.frc.AHRS;

import frc.robot.Robot;
import frc.robot.RobotContainer;
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
          //.andThen(new DriveForTime(driveTrain,2, -0.5, 0))
          .andThen(new BalanceDrive(driveTrain, gyro, true))
       );
      }
}
