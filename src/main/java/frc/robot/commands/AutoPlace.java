package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Wings;

public class AutoPlace extends SequentialCommandGroup{
  private Arm arm;
    public AutoPlace(DriveTrain driveTrain, Wings wings,Arm ARm) {
      arm = ARm;
      addRequirements(driveTrain);
      addRequirements(wings);
      addRequirements(arm);

       addCommands(
          new WingsExtend(wings)
          //.andThen(new DriveForTime(driveTrain,2, -0.4, 0))
          .andThen(new WaitCommand(1))
          .andThen(new ArmHighThrow(arm,wings))
          .andThen(new WaitCommand(0.2))
          .andThen(new ArmReturnInside(arm, wings))
          .andThen(new WaitCommand(0.4))
          .andThen(new WingsRetract(wings))
          .andThen(new DriveForTime(driveTrain,2, -0.4, 0), new ArmReturnInside(arm,wings))
          //.andThen(new DriveForTime(driveTrain, 3, 0, 0))
          //.andThen(new WingsRetract(wings))
       );
         // drive forward to place cone
          // place cone
          // drive back closer to substation
        
      }     
}
