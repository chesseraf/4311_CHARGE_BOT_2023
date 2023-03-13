package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;

public class ArmHighThrow extends SequentialCommandGroup{
    public ArmHighThrow(Arm Arm){
        addCommands(new ArmAngleMove(Arm, -50000, -0.5,false)
        .andThen(new ArmAngleMove(Arm, -150000, -1,true))
        );
    }
}
