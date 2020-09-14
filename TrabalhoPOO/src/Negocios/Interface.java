package Apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Dados.Medico;
import Dados.Paciente;
import Dados.Pessoa;
import Negocios.Sistema;

public class Interface {

	static Sistema sistema = new Sistema();
	
	private JFrame frmHospitalSystem;
	
	private JTextField nomeField;
	private JTextField idadeField;
	private JTextField cpfField;
	private JTextField cidadeField;
	private JTextField descricaoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frmHospitalSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmHospitalSystem = new JFrame();
		frmHospitalSystem.setTitle("Hospital System");
		frmHospitalSystem.setBounds(100, 100 , 1000, 600);
		frmHospitalSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHospitalSystem.setLocationRelativeTo(null);
		frmHospitalSystem.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(140, 70, 820, 481);
		frmHospitalSystem.getContentPane().add(panel);
		panel.setLayout(null);

		
		

		
		JButton btnCadastrarPaciente = new JButton("Cadastar Paciente");
		btnCadastrarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCadastrarPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				JPanel panel = new JPanel();
				panel.setBounds(140, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(panel);
				panel.setLayout(null);
				
				nomeField = new JTextField();
				nomeField.setBounds(10, 29, 800, 33);
				panel.add(nomeField);
				nomeField.setColumns(10);
				nomeField.setText("Nome");
				
				idadeField = new JTextField();
				idadeField.setColumns(10);
				idadeField.setBounds(10, 73, 800, 33);
				panel.add(idadeField);
				idadeField.setText("Idade");
				
				cpfField = new JTextField();
				cpfField.setColumns(10);
				cpfField.setBounds(10, 117, 800, 33);
				panel.add(cpfField);
				cpfField.setText("CPF");
				
				cidadeField = new JTextField();
				cidadeField.setColumns(10);
				cidadeField.setBounds(10, 161, 800, 33);
				panel.add(cidadeField);
				cidadeField.setText("Cidade");
				
				descricaoField = new JTextField();
				descricaoField.setColumns(10);
				descricaoField.setBounds(10, 205, 800, 170);
				panel.add(descricaoField);
				descricaoField.setText("Descri\u00E7\u00E3o\r\n\r\n\r\n\r\n\r\n");
				
				JButton btnCadastrar = new JButton("Cadastrar");
				btnCadastrar.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						Paciente paciente = new Paciente();
						 Pessoa pessoa = new Pessoa();
						 String aux;
						 
						 
						 pessoa.setNome(nomeField.getText());
						 aux = idadeField.getText();
						 int idade = Integer.parseInt(aux);
						 pessoa.setIdade(idade);
						 pessoa.setCpf(cpfField.getText());
						 pessoa.setCidade(cidadeField.getText());
						 
						 paciente.setDescricao(descricaoField.getText());
						 
						sistema.cadastrarPessoa(pessoa);
						paciente.setIdPes(sistema.buscarPessoa(pessoa.getCpf()).getId());
						sistema.cadastrarPaciente(paciente);
					
						
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso !");
					}
				});
				btnCadastrar.setBounds(686, 422, 124, 40);
				panel.add(btnCadastrar);
				
			}
		});
		btnCadastrarPaciente.setBounds(10, 70, 120, 30);
		frmHospitalSystem.getContentPane().add(btnCadastrarPaciente);
		
		JButton btnCadastarMedico = new JButton("Cadastar Medico");
		btnCadastarMedico.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCadastarMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel panel = new JPanel();
				panel.setBounds(140, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(panel);
				panel.setLayout(null);
				
				nomeField = new JTextField();
				nomeField.setBounds(10, 29, 800, 33);
				panel.add(nomeField);
				nomeField.setColumns(10);
				nomeField.setText("Nome");
				
				idadeField = new JTextField();
				idadeField.setColumns(10);
				idadeField.setBounds(10, 73, 800, 33);
				panel.add(idadeField);
				idadeField.setText("Idade");
				
				cpfField = new JTextField();
				cpfField.setColumns(10);
				cpfField.setBounds(10, 117, 800, 33);
				panel.add(cpfField);
				cpfField.setText("CPF");
				
				cidadeField = new JTextField();
				cidadeField.setColumns(10);
				cidadeField.setBounds(10, 161, 800, 33);
				panel.add(cidadeField);
				cidadeField.setText("Cidade");
				
				descricaoField = new JTextField();
				descricaoField.setColumns(10);
				descricaoField.setBounds(10, 205, 800, 170);
				panel.add(descricaoField);
				descricaoField.setText("Especialidade");
				
				JButton btnCadastrar = new JButton("Cadastrar");
				btnCadastrar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					   	 Medico medico = new Medico();
						 Pessoa pessoa = new Pessoa();
						 String aux;
						 
						 
						 pessoa.setNome(nomeField.getText());
						 aux = idadeField.getText();
						 int idade = Integer.parseInt(aux);
						 pessoa.setIdade(idade);
						 pessoa.setCpf(cpfField.getText());
						 pessoa.setCidade(cidadeField.getText());
						 
						 medico.setEspecialidade(descricaoField.getText());
						 
						sistema.cadastrarPessoa(pessoa);
						medico.setIdPes(sistema.buscarPessoa(pessoa.getCpf()).getId());
						sistema.cadastrarMedico(medico);
					
						
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso !");
					}
				});
				btnCadastrar.setBounds(686, 422, 124, 40);
				panel.add(btnCadastrar);
			}
		});
		btnCadastarMedico.setBounds(10, 111, 120, 30);
		frmHospitalSystem.getContentPane().add(btnCadastarMedico);
		
		JButton btnCadastarConsulta = new JButton("Cadastar Consulta");
		btnCadastarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCadastarConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new JPanel();
				panel.setBounds(140, 70, 820, 680);
				frmHospitalSystem.getContentPane().add(panel);
			}
		});
		btnCadastarConsulta.setBounds(10, 152, 120, 30);
		frmHospitalSystem.getContentPane().add(btnCadastarConsulta);
		
		JButton btnListarPacientes = new JButton("Listar Pacientes");
		btnListarPacientes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnListarPacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new JPanel();
				panel.setBounds(140, 70, 820, 680);
				frmHospitalSystem.getContentPane().add(panel);
			}
		});
		btnListarPacientes.setBounds(10, 193, 120, 30);
		frmHospitalSystem.getContentPane().add(btnListarPacientes);
		
		JButton btnListarMedicos = new JButton("Listar Medicos");
		btnListarMedicos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnListarMedicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new JPanel();
				panel.setBounds(140, 70, 820, 680);
				frmHospitalSystem.getContentPane().add(panel);
			}
		});
		btnListarMedicos.setBounds(10, 234, 120, 30);
		frmHospitalSystem.getContentPane().add(btnListarMedicos);
		
		JButton btnListarConsultas = new JButton("Listar Consultas");
		btnListarConsultas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnListarConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnListarConsultas.setBounds(10, 275, 120, 30);
		frmHospitalSystem.getContentPane().add(btnListarConsultas);
		
		JButton btnAlterarPaciente = new JButton("Alterar Paciente");
		btnAlterarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAlterarPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnAlterarPaciente.setBounds(10, 316, 120, 30);
		frmHospitalSystem.getContentPane().add(btnAlterarPaciente);
		
		JButton btnAlterarMedico = new JButton("Alterar Medico");
		btnAlterarMedico.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAlterarMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnAlterarMedico.setBounds(10, 357, 120, 30);
		frmHospitalSystem.getContentPane().add(btnAlterarMedico);
		
		JButton btnAlterarConsulta = new JButton("Alterar Consulta");
		btnAlterarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAlterarConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnAlterarConsulta.setBounds(10, 398, 120, 30);
		frmHospitalSystem.getContentPane().add(btnAlterarConsulta);
		
		JButton btnExcluirPaciente = new JButton("Excluir Paciente");
		btnAlterarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAlterarConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnExcluirPaciente.setBounds(10, 439, 120, 30);
		frmHospitalSystem.getContentPane().add(btnExcluirPaciente);
		
		JButton btnExcluirMedico = new JButton("Ecluir Medico");
		btnExcluirPaciente.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnExcluirPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnExcluirMedico.setBounds(10, 480, 120, 30);
		frmHospitalSystem.getContentPane().add(btnExcluirMedico);
		
		JButton btnExcluirConsulta = new JButton("Excluir Consulta");
		btnExcluirConsulta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnExcluirMedico.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnExcluirMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnExcluirConsulta.setBounds(10, 521, 120, 30);
		frmHospitalSystem.getContentPane().add(btnExcluirConsulta);
		
	}
}
