package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Wings;

public class autoPlace extends SequentialCommandGroup{
    public autoPlace(DriveTrain driveTrain, Wings wings) {
        addRequirements(driveTrain);
        addCommands(new driveForTime(driveTrain,0, 0, 0)
  //andThen  drive forward to place cone
          // place cone
          // drive back closer to substation
        );
      }     
}
