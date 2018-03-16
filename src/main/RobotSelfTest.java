package main;

import edu.wpi.first.wpilibj.command.WaitCommand;
import interfacesAndAbstracts.ImprovedCommandGroup;
import main.commands.drivetrain.DriveTrainOff;
import main.commands.drivetrain.TimedDrive;
import main.commands.drivetrain.TimedTurn;
import main.commands.elevator.MoveToBottom;
import main.commands.elevator.MoveToSwitch;
import main.commands.elevator.MoveToTop;
import main.commands.intake.SpinIn;
import main.commands.intake.SpinOff;
import main.commands.intake.SpinOut;
import main.commands.pneumatics.arm.ArmClose;
import main.commands.pneumatics.arm.ArmOpen;
import main.commands.pneumatics.shift.ShiftDown;
import main.commands.pneumatics.shift.ShiftUp;
import main.commands.pneumatics.tilt.TiltDown;
import main.commands.pneumatics.tilt.TiltUp;

public class RobotSelfTest extends ImprovedCommandGroup {
	//In the future this should be improved, such that it implements
	//sensor checking to determine if motors are at the correct speed, voltage, and current
	//and that all other sensors, network interfaces, and systems are working properly
	public RobotSelfTest() {
		/***********************
		 * Drive Systems Test
		 */
		//Increment Forwards Drive
		addSequential(new TimedDrive(0.1, 0.2));
		addSequential(new TimedDrive(0.2, 0.2));
		addSequential(new TimedDrive(0.3, 0.2));
		addSequential(new TimedDrive(0.4, 0.2));
		addSequential(new TimedDrive(0.5, 0.2));
		addSequential(new TimedDrive(0.6, 0.2));
		addSequential(new TimedDrive(0.7, 0.2));
		addSequential(new TimedDrive(0.8, 0.2));
		addSequential(new TimedDrive(0.9, 0.2));
		addSequential(new TimedDrive(1.0, 0.2));
		
		//Stop & Wait
		addSequential(new DriveTrainOff());
		addSequential(new WaitCommand(0.25));
		
		//Increment Backwards Drive
		addSequential(new TimedDrive(-0.1, 0.2));
		addSequential(new TimedDrive(-0.2, 0.2));
		addSequential(new TimedDrive(-0.3, 0.2));
		addSequential(new TimedDrive(-0.4, 0.2));
		addSequential(new TimedDrive(-0.5, 0.2));
		addSequential(new TimedDrive(-0.6, 0.2));
		addSequential(new TimedDrive(-0.7, 0.2));
		addSequential(new TimedDrive(-0.8, 0.2));
		addSequential(new TimedDrive(-0.9, 0.2));
		addSequential(new TimedDrive(-1.0, 0.2));
		
		//Stop & Wait
		addSequential(new DriveTrainOff());
		addSequential(new WaitCommand(0.25));
		
		//Increment Left Turn
		addSequential(new TimedTurn(TurnMode.LEFT, 0.1, 0.2));
		addSequential(new TimedTurn(TurnMode.LEFT, 0.2, 0.2));
		addSequential(new TimedTurn(TurnMode.LEFT, 0.3, 0.2));
		addSequential(new TimedTurn(TurnMode.LEFT, 0.4, 0.2));
		addSequential(new TimedTurn(TurnMode.LEFT, 0.5, 0.2));
		addSequential(new TimedTurn(TurnMode.LEFT, 0.6, 0.2));
		addSequential(new TimedTurn(TurnMode.LEFT, 0.7, 0.2));
		addSequential(new TimedTurn(TurnMode.LEFT, 0.8, 0.2));
		addSequential(new TimedTurn(TurnMode.LEFT, 0.9, 0.2));
		addSequential(new TimedTurn(TurnMode.LEFT, 1.0, 0.2));
		
		//Stop & Wait
		addSequential(new DriveTrainOff());
		addSequential(new WaitCommand(0.25));

		
		//Increment Right Turn
		addSequential(new TimedTurn(TurnMode.RIGHT, 0.1, 0.2));
		addSequential(new TimedTurn(TurnMode.RIGHT, 0.2, 0.2));
		addSequential(new TimedTurn(TurnMode.RIGHT, 0.3, 0.2));
		addSequential(new TimedTurn(TurnMode.RIGHT, 0.4, 0.2));
		addSequential(new TimedTurn(TurnMode.RIGHT, 0.5, 0.2));
		addSequential(new TimedTurn(TurnMode.RIGHT, 0.6, 0.2));
		addSequential(new TimedTurn(TurnMode.RIGHT, 0.7, 0.2));
		addSequential(new TimedTurn(TurnMode.RIGHT, 0.8, 0.2));
		addSequential(new TimedTurn(TurnMode.RIGHT, 0.9, 0.2));
		addSequential(new TimedTurn(TurnMode.RIGHT, 1.0, 0.2));
		
		//Stop & Wait
		addSequential(new DriveTrainOff());
		addSequential(new WaitCommand(0.25));

		//Shifting
		addSequential(new TimedDrive(1.0, 1));
		addSequential(new TimedDrive(1.0, 1));
		addParallel(new ShiftUp());
		addSequential(new TimedDrive(1.0, 1));
		addParallel(new ShiftDown());
		
		//Stop & Wait
		addSequential(new DriveTrainOff());
		addSequential(new WaitCommand(0.25));
				
		/***********************
		 * Pneumatics System Test
		 */
		//Intake Tilt Down
		addSequential(new TiltDown());
		
		//Wait
		addSequential(new WaitCommand(0.25));
		
		//Intake Open/Close
		addSequential(new ArmOpen());
		addSequential(new WaitCommand(0.25));
		addSequential(new ArmClose());
		
		//Wait
		addSequential(new WaitCommand(0.25));
		
		//Intake Tilt Up
		addSequential(new TiltUp());
		
		//Wait
		addSequential(new WaitCommand(0.25));
		
		//Intake Open/Close
		addSequential(new ArmOpen());
		addSequential(new WaitCommand(0.25));
		addSequential(new ArmClose());
		
		//Wait
		addSequential(new WaitCommand(0.25));
		
		
		/***********************
		 * Elevator System Test
		 */
		//Lift To Switch Height
		addSequential(new MoveToSwitch(3));
		
		//Wait
		addSequential(new WaitCommand(0.25));
		
		//Elevator To Bottom
		addSequential(new MoveToBottom(3));
		
		//Wait
		addSequential(new WaitCommand(0.25));
		
		//Lift To Max Height
		addSequential(new MoveToTop(5));
			
		//Wait
		addSequential(new WaitCommand(0.25));
		
		//ElevatorToBottom
		addSequential(new MoveToBottom(3));
			
		//Wait
		addSequential(new WaitCommand(0.25));				
		
		
		/***********************
		 * Intake System Test
		 */
		//Spin In
		addSequential(new SpinIn());
		addParallel(new WaitCommand(1));//Force previous command to run for 1 second
		addSequential(new SpinOff());
		
		//Wait
		addSequential(new WaitCommand(0.25));	
		
		//Spin Out
		addSequential(new SpinOut());
		addParallel(new WaitCommand(1));//Force previous command to run for 1 second
		addSequential(new SpinOff());
	}
}