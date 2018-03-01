package main.commands.auto;

import edu.wpi.first.wpilibj.command.WaitCommand;
import interfacesAndAbstracts.ImprovedCommandGroup;
import main.Constants.TurnMode;
import main.commands.commandgroups.cubeManipulator.DropCube;
import main.commands.commandgroups.cubeManipulator.DropCubeOff;
import main.commands.drivetrain.TimedDrive;
import main.commands.drivetrain.TimedTurn;
import main.commands.elevator.TimedLift;

public class LeftToLeftScale extends ImprovedCommandGroup {
	public LeftToLeftScale() {
		addSequential(new TimedDrive(timedDrivePercent, 238.66/timedDistanceMultiplier));
		addSequential(new TimedTurn(TurnMode.Right, timedTurnPercent, timedTurn45degTime));
		addSequential(new TimedLift(timedLiftPercent, timedLiftFullHeightTime));
		addSequential(new TimedDrive(timedDrivePercent, 67.3/timedDistanceMultiplier));
		addSequential(new WaitCommand(0.1));
		addSequential(new DropCube());
		addSequential(new WaitCommand(0.5));
		addSequential(new DropCubeOff());	
	}
}
