package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;

public class ArmMidPlace extends  SequentialCommandGroup{
    public ArmMidPlace(Arm Arm){
        addCommands(new ArmMotorTimeMove(Arm, 1.5, 0.2)
        .andThen(new ArmMotorTimeMove(Arm, 1.5, 0.15))
        );
    }
    
}