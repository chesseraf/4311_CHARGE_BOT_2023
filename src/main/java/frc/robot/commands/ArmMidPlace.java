package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;

public class ArmMidPlace extends  SequentialCommandGroup{
    public ArmMidPlace(Arm Arm){
        addCommands(new ArmAngleMove(Arm, -20000, -0.5,false)
        .andThen(new ArmAngleMove(Arm, -210000, -1,true)));
    }
}
