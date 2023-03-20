package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Wings;

public class ArmLowPlace extends SequentialCommandGroup{
    public ArmLowPlace(Arm Arm, Wings wing, boolean comeBack){
        addRequirements(Arm);
        addRequirements(wing);
            if(comeBack){
                addCommands(
                new WingsExtend(wing)
                .andThen(new ArmAngleSpeed(Arm, -60000, -0.4,-0.4,false, wing))
                .andThen(new ArmAngleSpeed(Arm, -60000, 0, 0, false, wing))
                .andThen(new WaitCommand(0.3))
                .andThen(new ArmReturnInside(Arm,wing))
                );
            } else {
                addCommands(
                new WingsExtend(wing)
                .andThen(new ArmAngleSpeed(Arm, -60000, -0.4,-0.4,false, wing))
                .andThen(new ArmAngleSpeed(Arm, -60000, 0,0,false, wing))
                
                //.andThen(new WaitCommand(0.3))
                //.andThen(new ArmReturnInside(Arm,wing))
                );
            }
               
    }
}
