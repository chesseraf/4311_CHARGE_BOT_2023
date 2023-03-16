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
            new WingsRetract(wing)
            .andThen(new ArmAngleSpeed(Arm, -70000, -0.8,-0.7,false))
            .andThen(new ArmAngleSpeed(Arm, -150000, -1,-0.8,true))
            .andThen(new WaitCommand(0.2))
            .andThen(new ArmReturnInside(Arm))
            .andThen(new WaitCommand(3))
            .andThen(new WingsRetract(wing))
            );
        
    }
}
