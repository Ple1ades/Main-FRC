package frc.robot.commands;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import frc.robot.subsystems.Pneumatic;

import edu.wpi.first.wpilibj2.command.CommandBase;


// minimum air pressure = 0
// maxmm air pressure = 0
public class PneumaticMoveForward extends CommandBase{
    
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final Pneumatic m_piston;
    public PneumaticMoveForward(Pneumatic piston){
        m_piston = piston;
        addRequirements(piston);
    }
    
    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        
        m_piston.move(Value.kForward);
    }

    @Override
    public void end(boolean interrupted){
        
    }

    @Override
    public boolean isFinished(){
        return false;
    }


}
