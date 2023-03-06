package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.interfaces.Gyro;

import frc.robot.subsystems.DriveTrain;

public class autoBalance extends SequentialCommandGroup{
    public autoBalance(DriveTrain driveTrain, Gyro gyro) {
        addRequirements(driveTrain);
       // drive forward to place cone
       // place cone
       // drive back to the charge station
       // active drive based on gyro value
        addCommands(new driveForTime(driveTrain,0, 0, 0).
        andThen(new driveForTime(driveTrain,2, -0.2, 0)
        ));
      }
}
