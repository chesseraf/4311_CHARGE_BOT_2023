package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Wings;

public class ArmHighThrow extends SequentialCommandGroup{
    public ArmHighThrow(Arm Arm, Wings wing){
        addRequirements(Arm);
        addRequirements(wing);
            addCommands(
            new WingsExtend(wing)
            .andThen(new ArmAngleSpeed(Arm, -40000, -0.9,-0.65,false, wing))
            .andThen(new ArmAngleSpeed(Arm, -80000, -0.91,-0.9,true, wing))
            .andThen(new WaitCommand(0.3))
            .andThen(new ArmReturnInside(Arm, wing))
           // .andThen(new WaitCommand(3))
            //.andThen(new WingsRetract(wing))
            );
        
    }
}
