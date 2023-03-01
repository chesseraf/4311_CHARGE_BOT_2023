package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Wings;

public class WingFlap extends CommandBase{
    private Wings wings;
    private boolean flapping;
    
    public WingFlap(Wings Wings){
        wings = Wings;
        addRequirements(wings);
    }
    @Override
    public void initialize() {
        flapping = false;
    }
    @Override
    public void execute() {
        if(!flapping){
            //not flapping 
            if(RobotContainer.wingFlapButton){
                wings.WingSwitch();
                flapping = true;
            } else {
                flapping = false;
            }
        } else {
            //if flapping
            if(RobotContainer.wingFlapButton){
                flapping = true;
            } else {
                flapping = false;
            }
        }
    }
    @Override 
    public boolean isFinished(){
        return false;
    }    
}
