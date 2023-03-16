package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;

public class ArmMidPlace extends  SequentialCommandGroup{
    public ArmMidPlace(Arm Arm){
        addCommands(new ArmAngleSpeed(Arm, -70000, -0.8,-0.7,false)
        .andThen(new ArmAngleSpeed(Arm, -210000, -1,-0.8,true)));
    }
}
