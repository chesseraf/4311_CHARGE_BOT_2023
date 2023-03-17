package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Wings;

public class ArmLowPlace extends SequentialCommandGroup{
    public ArmLowPlace(Arm Arm, Wings wing){
        addRequirements(Arm);
        addRequirements(wing);
        
            addCommands(
            new WingsExtend(wing)
            .andThen(new ArmAngleSpeed(Arm, -50000, -0.4,-0.4,true, wing))
            //.andThen(new ArmAngleSpeed(Arm, -80000, -1,-0.8,true, wing))
            .andThen(new WaitCommand(0.3))
            .andThen(new ArmReturnInside(Arm,wing))
            //.andThen(new WaitCommand(3))
            //.andThen(new WingsRetract(wing))
            );   
    }
}
