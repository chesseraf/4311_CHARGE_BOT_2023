package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Wings;

public class WingsRetract extends CommandBase{
    private Wings wing;
    
    public WingsRetract(Wings Wings){
        wing = Wings;
        addRequirements(wing);
    }
    @Override
    public void initialize() {
        wing.WingsIn();
    }
    @Override
    public boolean isFinished(){
        return true;
    }
}
