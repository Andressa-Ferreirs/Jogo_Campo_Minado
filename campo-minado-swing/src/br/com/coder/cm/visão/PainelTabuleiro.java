package br.com.coder.cm.vis�o;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.com.coder.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {

	public PainelTabuleiro(Tabuleiro tabuleiro) {
		
		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));
		
		tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
		tabuleiro.registrarObservador(e -> {
			//mostrar resultado pro usu�rio
			SwingUtilities.invokeLater(() -> { 
			if (e.isGanhou()) {
				JOptionPane.showMessageDialog(this, "Voc� ganhou!!!");
			} else {
				JOptionPane.showMessageDialog(this, "Voc� perdeu :(");	
			}
			
			tabuleiro.reiniciar();
			});
			
		});
	}
}
	