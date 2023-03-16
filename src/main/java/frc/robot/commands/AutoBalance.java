package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;

public class AutoBalance extends SequentialCommandGroup{
    public AutoBalance(DriveTrain driveTrain, Gyro gyro) {
        addRequirements(driveTrain);
       // drive forward to place cone
       // place cone
       // drive back to the charge station
       // active drive based on gyro value
        addCommands(new DriveForTime(driveTrain,2, 0, 0)
        //.andThen(new ArmHighThrow(Arm))
        .andThen(new DriveForTime(driveTrain,2, 0, 0))
        .andThen(new DriveForTime(driveTrain, 2, 0, 0))

        );
      }
}
