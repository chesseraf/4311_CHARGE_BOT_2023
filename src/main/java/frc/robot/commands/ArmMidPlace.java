package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;

public class ArmMidPlace extends  SequentialCommandGroup{
    public ArmMidPlace(Arm Arm){
        addCommands(new ArmAngleMove(Arm, -180000, -1)
        .andThen(new ArmAngleMove(Arm, -240000, -0.8)));
    }
}
