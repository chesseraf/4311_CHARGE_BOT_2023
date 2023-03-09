package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;

public class SlightPlacingTurn extends SequentialCommandGroup{
    public SlightPlacingTurn(DriveTrain driveTrain){
        CommandScheduler.getInstance().schedule(new DriveForTime(null, 0.2, 0, 0.15));
    }

    
}
