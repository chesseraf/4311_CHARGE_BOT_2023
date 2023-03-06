package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.WingFlap;
import frc.robot.commands.armWork;
import frc.robot.commands.autoBalance;
import frc.robot.commands.autoPlace;
import frc.robot.commands.balanceDrive;
import frc.robot.commands.driveWithJoystick;
import frc.robot.commands.putCone;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Wings;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class RobotContainer {
    public final static Joystick THRUSTMASTER = new Joystick(Constants.ports.thrusty);
    final DriveTrain DRIVE_TRAIN = new DriveTrain();

    // timers
    public static int timer;
    public static int pistonTimer;
    public static int [] timers;
/* 
    //auto chooser
    private static final String balanceAuto = "Default";
    private static final String placeAuto = "My Auto";
    private String autoChosen;
    private final SendableChooser<String> autoChoice = new SendableChooser<>();
*/
    final AnalogGyro GYRO = new AnalogGyro(0);

    private final DoubleSolenoid LEFT_WING = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.ports.leftWingExtend, Constants.ports.leftWingRetract);
    private final DoubleSolenoid RIGHT_WING = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.ports.rightWingExtend, Constants.ports.rightWingRetract);
    private final DoubleSolenoid armCone = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.ports.armConeExtend, Constants.ports.armConeRetract);

    private final Wings WINGS = new Wings(LEFT_WING, RIGHT_WING);

    private final WPI_TalonFX ARM_TALON = new WPI_TalonFX(Constants.ports.arm);
    private final Arm ARM = new Arm(ARM_TALON);

    public static boolean wingsInside;
    public static boolean wingFlapButton;
    public static boolean rightWingFlapButton;
    public static boolean leftWingFlapButton;
    
    public static boolean armOutButton;
    public static boolean armInButton;

    public static double joystickX;
    public static double joystickY;

   // private final  JoystickButton orangeButton = new JoystickButton(THRUSTMASTER, pistonTimer);
    private final Command ARM_COMMAND = new armWork(ARM);
    private final Command AUTO_BALANCE_COMMAND = new autoBalance(DRIVE_TRAIN, GYRO);
    private final Command AUTO_PLACE_COMMAND = new autoPlace(DRIVE_TRAIN, WINGS);
    private final Command BALANCE_DRIVE_COMMAND = new balanceDrive(DRIVE_TRAIN,GYRO);
    private final Command TELEOP_COMMAND = new driveWithJoystick(DRIVE_TRAIN, WINGS, GYRO);
    private final Command PUT_CONE_COMMAND = new putCone(DRIVE_TRAIN, WINGS);
    private final Command WING_FLAPPER_COMMAND = new WingFlap(WINGS);
    //private final CommandBase 

    public Command GetArmCommand(){
        return ARM_COMMAND;
    }
    public Command GetAutoBalanceCommand(){
        return AUTO_BALANCE_COMMAND;
    }
    public Command GetAutoPlaceCommand(){
        return AUTO_PLACE_COMMAND;
    }
    public Command GetBalanceDriveCommand(){
        return BALANCE_DRIVE_COMMAND;
    }
    public Command GetTeleopCommand(){
        return TELEOP_COMMAND;
    }
    public Command GetPutConeCommand(){
        return PUT_CONE_COMMAND;
    }
    public Command GetWingFlapCommand(){
        return WING_FLAPPER_COMMAND;
    }

    public void SmartBoardUpdate(){
        SmartDashboard.putNumber("gyro angle ", GYRO.getAngle());
        SmartDashboard.putNumber("gyro rate ", GYRO.getRate());
        SmartDashboard.putBoolean("piston extended ", wingsInside);
    }

    public void UpdateJoystick(){
        joystickX = THRUSTMASTER.getX();
        joystickY = THRUSTMASTER.getY();
        wingFlapButton = THRUSTMASTER.getRawButton(Constants.buttons.flapWings);
        rightWingFlapButton = THRUSTMASTER.getRawButton(Constants.buttons.flapRight);
        leftWingFlapButton = THRUSTMASTER.getRawButton(Constants.buttons.flapLeft);
        armInButton = THRUSTMASTER.getRawButton(Constants.buttons.armIn);
        armOutButton = THRUSTMASTER.getRawButton(Constants.buttons.armOut);
        //add more buttons
    }
    public RobotContainer(){}
}
