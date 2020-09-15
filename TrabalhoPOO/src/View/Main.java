package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Dados.Consulta;
import Dados.Medico;
import Dados.Paciente;
import Dados.Pessoa;
import Negocios.Sistema;
import Persistencia.ConsultaDAO;
import Persistencia.MedicoDAO;
import Persistencia.PacienteDAO;
import exceptions.SelectException;
import javax.swing.JComboBox;

public class Main {

	static Sistema sistema = new Sistema();
	
	private JFrame frmHospitalSystem;
	
	JPanel cadastrarPanelP = new JPanel();
	JPanel cadastrarPanelM = new JPanel();
	JPanel cadastrarPanelC = new JPanel();
	JPanel listarPanelP = new JPanel();
	JPanel listarPanelM = new JPanel();
	JPanel listarPanelC = new JPanel();
	JPanel alterarPanelP = new JPanel();
	JPanel alterarPanelM = new JPanel();
	JPanel alterarPanelC = new JPanel();
	JPanel deletePanelP = new JPanel();
	JPanel deletePanelM = new JPanel();
	JPanel deletePanelC = new JPanel();
	
	JTable tblPacientes = new JTable();
	JTable tblMedicos = new JTable();
	JTable tblConsultas = new JTable();
	
	private JTextField nomeField;
	private JTextField valorField;
	private JTextField cpfField;
	private JTextField idadeField;
	private JTextField cidadeField;
	private JTextField descricaoField;
	private JTextField horarioField;
	private JTextField diagnosticoField;
	
	JComboBox comboMedico;
	JComboBox comboPaciente;
	JComboBox comboConsulta;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmHospitalSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		
		frmHospitalSystem = new JFrame();
		frmHospitalSystem.setTitle("Hospital System");
		frmHospitalSystem.setBounds(100, 100 , 1000, 600);
		frmHospitalSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHospitalSystem.setLocationRelativeTo(null);
		frmHospitalSystem.getContentPane().setLayout(null);
				
		JButton btnCadastrarPaciente = new JButton("Cadastar Paciente");
		btnCadastrarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCadastrarPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarPanelP.setVisible(true);
				cadastrarPanelM.setVisible(false);
				cadastrarPanelC.setVisible(false);
				listarPanelP.setVisible(false);
				listarPanelM.setVisible(false);
				listarPanelC.setVisible(false);
				alterarPanelP.setVisible(false);
				alterarPanelM.setVisible(false);
				alterarPanelC.setVisible(false);
				deletePanelP.setVisible(false);
				deletePanelM.setVisible(false);
				deletePanelC.setVisible(false);
				
				LayoutManager overlay = new OverlayLayout(cadastrarPanelP);
				cadastrarPanelP.setLayout(overlay);
				JButton btnCadastrar = new JButton("Cadastrar");
				cadastrarPanelP.add(btnCadastrar);
							
				cadastrarPanelP.setBounds(140, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(cadastrarPanelP);
				cadastrarPanelP.setLayout(null);
				
				nomeField = new JTextField();
				nomeField.setBounds(10, 29, 800, 33);
				cadastrarPanelP.add(nomeField);
				nomeField.setColumns(10);
				nomeField.setText("Nome");
				
				idadeField = new JTextField();
				idadeField.setColumns(10);
				idadeField.setBounds(10, 73, 800, 33);
				cadastrarPanelP.add(idadeField);
				idadeField.setText("Idade");
				
				cpfField = new JTextField();
				cpfField.setColumns(10);
				cpfField.setBounds(10, 117, 800, 33);
				cadastrarPanelP.add(cpfField);
				cpfField.setText("CPF");
				
				cidadeField = new JTextField();
				cidadeField.setColumns(10);
				cidadeField.setBounds(10, 161, 800, 33);
				cadastrarPanelP.add(cidadeField);
				cidadeField.setText("Cidade");
				
				descricaoField = new JTextField();
				descricaoField.setColumns(10);
				descricaoField.setBounds(10, 205, 800, 170);
				cadastrarPanelP.add(descricaoField);
				descricaoField.setText("Descri\u00E7\u00E3o\r\n\r\n\r\n\r\n\r\n");
				
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
						cadastrarPanelP.setVisible(false);
					}
				});
				btnCadastrar.setBounds(686, 422, 124, 40);				
			}
		});
		btnCadastrarPaciente.setBounds(10, 70, 120, 30);
		frmHospitalSystem.getContentPane().add(btnCadastrarPaciente);
		
		JButton btnCadastarMedico = new JButton("Cadastar Medico");
		btnCadastarMedico.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCadastarMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarPanelP.setVisible(false);
				cadastrarPanelM.setVisible(true);
				cadastrarPanelC.setVisible(false);
				listarPanelP.setVisible(false);
				listarPanelM.setVisible(false);
				listarPanelC.setVisible(false);
				alterarPanelP.setVisible(false);
				alterarPanelM.setVisible(false);
				alterarPanelC.setVisible(false);
				deletePanelP.setVisible(false);
				deletePanelM.setVisible(false);
				deletePanelC.setVisible(false);
				
				LayoutManager overlay = new OverlayLayout(cadastrarPanelM);
				cadastrarPanelM.setLayout(overlay);
				JButton btnCadastrar = new JButton("Cadastrar");
				cadastrarPanelM.add(btnCadastrar);				

				cadastrarPanelM.setBounds(140, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(cadastrarPanelM);
				cadastrarPanelM.setLayout(null);
				
				nomeField = new JTextField();
				nomeField.setBounds(10, 29, 800, 33);
				cadastrarPanelM.add(nomeField);
				nomeField.setColumns(10);
				nomeField.setText("Nome");
				
				idadeField = new JTextField();
				idadeField.setColumns(10);
				idadeField.setBounds(10, 73, 800, 33);
				cadastrarPanelM.add(idadeField);
				idadeField.setText("Idade");
				
				cpfField = new JTextField();
				cpfField.setColumns(10);
				cpfField.setBounds(10, 117, 800, 33);
				cadastrarPanelM.add(cpfField);
				cpfField.setText("CPF");
				
				cidadeField = new JTextField();
				cidadeField.setColumns(10);
				cidadeField.setBounds(10, 161, 800, 33);
				cadastrarPanelM.add(cidadeField);
				cidadeField.setText("Cidade");
				
				descricaoField = new JTextField();
				descricaoField.setColumns(10);
				descricaoField.setBounds(10, 205, 800, 170);
				cadastrarPanelM.add(descricaoField);
				descricaoField.setText("Especialidade");
				
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
						cadastrarPanelM.setVisible(false);
					}
				});
				btnCadastrar.setBounds(686, 422, 124, 40);
				cadastrarPanelM.add(btnCadastrar);
			}
		});
		btnCadastarMedico.setBounds(10, 111, 120, 30);
		frmHospitalSystem.getContentPane().add(btnCadastarMedico);
		
		JButton btnCadastarConsulta = new JButton("Cadastar Consulta");
		btnCadastarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCadastarConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarPanelP.setVisible(false);
				cadastrarPanelM.setVisible(false);
				cadastrarPanelC.setVisible(true);
				listarPanelP.setVisible(false);
				listarPanelM.setVisible(false);
				listarPanelC.setVisible(false);
				alterarPanelP.setVisible(false);
				alterarPanelM.setVisible(false);
				alterarPanelC.setVisible(false);
				deletePanelP.setVisible(false);
				deletePanelM.setVisible(false);
				deletePanelC.setVisible(false);
			
				LayoutManager ol_panel_1 = new OverlayLayout(cadastrarPanelC);
				cadastrarPanelC.setLayout(ol_panel_1);
				JButton btnCadastrar = new JButton("Cadastrar");
				cadastrarPanelC.add(btnCadastrar);
				
				cadastrarPanelC.setBounds(140, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(cadastrarPanelC);
				cadastrarPanelC.setLayout(null);
				
				List<Medico> medicos = null;
				try {
					medicos = MedicoDAO.getInstance().selectAllMed();
				} catch (SelectException e2) {
					e2.printStackTrace();
				} 
				
				List<Paciente> pacientes = null;
				try {
					pacientes = PacienteDAO.getInstance().selectAllPac();
				} catch (SelectException e2) {
					e2.printStackTrace();
				} 
				
				comboPaciente = new JComboBox();
				cadastrarPanelC.add(comboPaciente);
				comboPaciente.setBounds(410, 250, 390, 33);
				comboPaciente.setVisible(true);
				comboPaciente.setModel(new ComboBoxModelAll(pacientes));	
				
				comboMedico = new JComboBox();
				cadastrarPanelC.add(comboMedico);
				comboMedico.setBounds(10, 250, 390, 33);
				comboMedico.setVisible(true);
				comboMedico.setModel(new ComboBoxModelAll(medicos));
				
				valorField = new JTextField();
				valorField.setBounds(10, 29, 800, 33);
				cadastrarPanelC.add(valorField);
				valorField.setColumns(10);
				valorField.setText("Valor");
				
				horarioField = new JTextField();
				horarioField.setText("00/00/0000 00:00");
				horarioField.setColumns(10);
				horarioField.setBounds(10, 73, 800, 33);
				cadastrarPanelC.add(horarioField);
				
				diagnosticoField = new JTextField();
				diagnosticoField.setText("Diagnostico");
				diagnosticoField.setColumns(10);
				diagnosticoField.setBounds(10, 117, 800, 108);
				cadastrarPanelC.add(diagnosticoField);
			
				btnCadastrar.addMouseListener(new MouseAdapter() {			
					@Override
					public void mouseClicked(MouseEvent e) {
						Consulta consulta = new Consulta();
						 String aux;

						 aux = valorField.getText();
						 int valor = Integer.parseInt(aux);
						 consulta.setValor(valor);
						 aux = horarioField.getText();
						 
						 SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
							Date dataFormatada;
							try {
								dataFormatada = dtf.parse(aux);
								 consulta.getHorario().setTime(dataFormatada);
							} catch (ParseException e1) {
								System.out.println("erro de formatação da data");
								return;
							}
							consulta.setDiagnostico(diagnosticoField.getText());
						 
						consulta.setMedico((Medico) comboMedico.getModel().getSelectedItem());
						consulta.setPaciente((Paciente) comboPaciente.getModel().getSelectedItem());
						 
						sistema.realizarConsulta(consulta);	
						
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso !");
						cadastrarPanelC.setVisible(false);
						comboMedico.setVisible(false);
						comboPaciente.setVisible(false);
					}
				});
				btnCadastrar.setBounds(686, 422, 124, 40);	
			}
		});
		btnCadastarConsulta.setBounds(10, 152, 120, 30);
		frmHospitalSystem.getContentPane().add(btnCadastarConsulta);
		
		JButton btnListarPacientes = new JButton("Listar Pacientes");
		btnListarPacientes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnListarPacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarPanelP.setVisible(false);
				cadastrarPanelM.setVisible(false);
				cadastrarPanelC.setVisible(false);
				listarPanelP.setVisible(true);
				listarPanelM.setVisible(false);
				listarPanelC.setVisible(false);
				alterarPanelP.setVisible(false);
				alterarPanelM.setVisible(false);
				alterarPanelC.setVisible(false);
				deletePanelP.setVisible(false);
				deletePanelM.setVisible(false);
				deletePanelC.setVisible(false);
				
				listarPanelP.setBounds(140, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(listarPanelP);
				listarPanelP.setLayout(null);

				tblPacientes.setBorder(new LineBorder(new Color(0, 0, 0)));
				tblPacientes.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID", "Nome", "CPF"
					}
				));
				tblPacientes.setBounds(64, 67, 546, 178);
				
				JScrollPane scrollPane = new JScrollPane(tblPacientes);
				scrollPane.setBounds(22, 11, 788, 385);
				listarPanelP.add(scrollPane);
				scrollPane.setViewportView(tblPacientes);
				ArrayList<Paciente> lista = null;
				try {
					lista = PacienteDAO.getInstance().selectAllPac();
				} catch (SelectException e1) {
					e1.printStackTrace();
				}
				atualizaTabelaP(lista);						
			}
		});
		btnListarPacientes.setBounds(10, 193, 120, 30);
		frmHospitalSystem.getContentPane().add(btnListarPacientes);
		
		JButton btnListarMedicos = new JButton("Listar Medicos");
		btnListarMedicos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnListarMedicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarPanelP.setVisible(false);
				cadastrarPanelM.setVisible(false);
				cadastrarPanelC.setVisible(false);
				listarPanelP.setVisible(false);
				listarPanelM.setVisible(true);
				listarPanelC.setVisible(false);
				alterarPanelP.setVisible(false);
				alterarPanelM.setVisible(false);
				alterarPanelC.setVisible(false);
				deletePanelP.setVisible(false);
				deletePanelM.setVisible(false);
				deletePanelC.setVisible(false);
								
				listarPanelM.setBounds(140, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(listarPanelM);
				listarPanelM.setLayout(null);

				tblMedicos.setBorder(new LineBorder(new Color(0, 0, 0)));
				tblMedicos.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID", "Nome", "CPF"
					}
				));
				tblMedicos.setBounds(64, 67, 546, 178);
				
				JScrollPane scrollPane = new JScrollPane(tblMedicos);
				scrollPane.setBounds(22, 11, 788, 385);
				listarPanelM.add(scrollPane);
				scrollPane.setViewportView(tblMedicos);
				ArrayList<Medico> lista = null;
				try {
					lista = MedicoDAO.getInstance().selectAllMed();
				} catch (SelectException e1) {
					e1.printStackTrace();
				}
				atualizaTabelaM(lista);
			}
		});
		btnListarMedicos.setBounds(10, 234, 120, 30);
		frmHospitalSystem.getContentPane().add(btnListarMedicos);
		
		JButton btnListarConsultas = new JButton("Listar Consultas");
		btnListarConsultas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnListarConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarPanelP.setVisible(false);
				cadastrarPanelM.setVisible(false);
				cadastrarPanelC.setVisible(false);
				listarPanelP.setVisible(false);
				listarPanelM.setVisible(false);
				listarPanelC.setVisible(true);
				alterarPanelP.setVisible(false);
				alterarPanelM.setVisible(false);
				alterarPanelC.setVisible(false);
				deletePanelP.setVisible(false);
				deletePanelM.setVisible(false);
				deletePanelC.setVisible(false);
							
				listarPanelC.setBounds(140, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(listarPanelC);
				listarPanelC.setLayout(null);

				tblConsultas.setBorder(new LineBorder(new Color(0, 0, 0)));
				tblConsultas.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID","Valor", "Horario", "ID Medico", "ID Paciente"
					}
				));
				tblConsultas.setBounds(64, 67, 546, 178);
				
				JScrollPane scrollPane = new JScrollPane(tblConsultas);
				scrollPane.setBounds(22, 11, 788, 385);
				listarPanelC.add(scrollPane);
				scrollPane.setViewportView(tblConsultas);
				ArrayList<Consulta> lista = null;
				try {
					lista = ConsultaDAO.getInstance().selectAllCon();
				} catch (SelectException e1) {
					e1.printStackTrace();
				}
				atualizaTabelaC(lista);
				
			}
		});
		btnListarConsultas.setBounds(10, 275, 120, 30);
		frmHospitalSystem.getContentPane().add(btnListarConsultas);
		
		JButton btnAlterarPaciente = new JButton("Alterar Paciente");
		btnAlterarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAlterarPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarPanelP.setVisible(false);
				cadastrarPanelM.setVisible(false);
				cadastrarPanelC.setVisible(false);
				listarPanelP.setVisible(false);
				listarPanelM.setVisible(false);
				listarPanelC.setVisible(false);
				alterarPanelP.setVisible(true);
				alterarPanelM.setVisible(false);
				alterarPanelC.setVisible(false);
				deletePanelP.setVisible(false);
				deletePanelM.setVisible(false);
				deletePanelC.setVisible(false);		
				
				LayoutManager ol_AlterarPanel = new OverlayLayout(alterarPanelP);
				alterarPanelP.setLayout(ol_AlterarPanel);
				JButton btnAlterar = new JButton("Alterar");
				alterarPanelP.add(btnAlterar);
				
				nomeField = new JTextField();
				alterarPanelP.add(nomeField);
				nomeField.setBounds(10, 49, 800, 33);
				nomeField.setColumns(10);
				nomeField.setText("Nome");
				
				idadeField = new JTextField();
				alterarPanelP.add(idadeField);
				idadeField.setColumns(10);
				idadeField.setBounds(10, 88, 800, 33);
				idadeField.setText("Idade");
				
				cidadeField = new JTextField();
				alterarPanelP.add(cidadeField);
				cidadeField.setColumns(10);
				cidadeField.setBounds(10, 127, 800, 33);
				cidadeField.setText("Cidade");
				
				descricaoField = new JTextField();
				alterarPanelP.add(descricaoField);
				descricaoField.setColumns(10);
				descricaoField.setBounds(10, 156, 800, 170);
				descricaoField.setText("Descri\u00E7\u00E3o\r\n\r\n\r\n\r\n\r\n");
				
				alterarPanelP.setBounds(154, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(alterarPanelP);
				alterarPanelP.setLayout(null);
				
				comboPaciente = new JComboBox();
				comboPaciente.setBounds(10, 10, 400, 30);
				alterarPanelP.add(comboPaciente);
								
				List<Paciente> pacientes = null;
				try {
					pacientes = PacienteDAO.getInstance().selectAllPac();
				} catch (SelectException e2) {
					e2.printStackTrace();
				} 
				comboPaciente.setModel(new ComboBoxModelAll(pacientes));
								
				btnAlterar.addMouseListener(new MouseAdapter() {				
					@Override
					public void mouseClicked(MouseEvent e) {
					Paciente paciente = new Paciente();
					Pessoa pessoa = new Pessoa();
					String aux;
					paciente = (Paciente) comboPaciente.getModel().getSelectedItem();
					comboPaciente.getModel().getSelectedItem().equals(pessoa);
					
					pessoa.setNome(nomeField.getText());
					 aux = idadeField.getText();
					 int idade = Integer.parseInt(aux);
					 pessoa.setIdade(idade);
					 pessoa.setCidade(cidadeField.getText());
					 
					 paciente.setDescricao(descricaoField.getText());
					
					sistema.alterarPaciente(paciente);
					sistema.alterarPessoa(pessoa);
					
						JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso !");
						alterarPanelP.setVisible(false);
					}
				});
				btnAlterar.setBounds(686, 422, 124, 40);
			}
		});
		btnAlterarPaciente.setBounds(10, 316, 120, 30);
		frmHospitalSystem.getContentPane().add(btnAlterarPaciente);
		
		JButton btnAlterarMedico = new JButton("Alterar Medico");
		btnAlterarMedico.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAlterarMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarPanelP.setVisible(false);
				cadastrarPanelM.setVisible(false);
				cadastrarPanelC.setVisible(false);
				listarPanelP.setVisible(false);
				listarPanelM.setVisible(false);
				listarPanelC.setVisible(false);
				alterarPanelP.setVisible(false);
				alterarPanelM.setVisible(true);
				alterarPanelC.setVisible(false);
				deletePanelP.setVisible(false);
				deletePanelM.setVisible(false);
				deletePanelC.setVisible(false);	
				
				LayoutManager ol_AlterarPanel = new OverlayLayout(alterarPanelM);
				alterarPanelM.setLayout(ol_AlterarPanel);
				JButton btnAlterar = new JButton("Alterar");
				alterarPanelM.add(btnAlterar);
				
				nomeField = new JTextField();
				alterarPanelM.add(nomeField);
				nomeField.setBounds(10, 49, 800, 33);
				nomeField.setColumns(10);
				nomeField.setText("Nome");
				
				idadeField = new JTextField();
				alterarPanelM.add(idadeField);
				idadeField.setColumns(10);
				idadeField.setBounds(10, 88, 800, 33);
				idadeField.setText("Idade");
				
				cidadeField = new JTextField();
				alterarPanelM.add(cidadeField);
				cidadeField.setColumns(10);
				cidadeField.setBounds(10, 127, 800, 33);
				cidadeField.setText("Cidade");
				
				descricaoField = new JTextField();
				alterarPanelM.add(descricaoField);
				descricaoField.setColumns(10);
				descricaoField.setBounds(10, 156, 800, 170);
				descricaoField.setText("Especialidade");
				
				alterarPanelM.setBounds(154, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(alterarPanelM);
				alterarPanelM.setLayout(null);
				
				comboMedico = new JComboBox();
				comboMedico.setBounds(10, 10, 330, 30);
				alterarPanelM.add(comboMedico);
								
				List<Medico> medicos = null;
				try {
					medicos = MedicoDAO.getInstance().selectAllMed();
				} catch (SelectException e2) {
					e2.printStackTrace();
				} 
				comboMedico.setModel(new ComboBoxModelAll(medicos));
				
					btnAlterar.addMouseListener(new MouseAdapter() {					
					@Override
					public void mouseClicked(MouseEvent e) {
					Medico medico = new Medico();
					Pessoa pessoa = new Pessoa();
					String aux;
					medico = (Medico) comboMedico.getModel().getSelectedItem();
					pessoa = (Medico) comboMedico.getModel().getSelectedItem();
					
					pessoa.setNome(nomeField.getText());
					 aux = idadeField.getText();
					 int idade = Integer.parseInt(aux);
					 pessoa.setIdade(idade);
					 pessoa.setCidade(cidadeField.getText());
					 
					 medico.setEspecialidade(descricaoField.getText());
					
					sistema.alterarMedico(medico);
					sistema.alterarPessoa(pessoa);
					
						JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso !");
						alterarPanelM.setVisible(false);
					}
				});
				btnAlterar.setBounds(686, 422, 124, 40);
			}
		});
		btnAlterarMedico.setBounds(10, 357, 120, 30);
		frmHospitalSystem.getContentPane().add(btnAlterarMedico);
		
		JButton btnAlterarConsulta = new JButton("Alterar Consulta");
		btnAlterarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAlterarConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarPanelP.setVisible(false);
				cadastrarPanelM.setVisible(false);
				cadastrarPanelC.setVisible(false);
				listarPanelP.setVisible(false);
				listarPanelM.setVisible(false);
				listarPanelC.setVisible(false);
				alterarPanelP.setVisible(false);
				alterarPanelM.setVisible(false);
				alterarPanelC.setVisible(true);
				deletePanelP.setVisible(false);
				deletePanelM.setVisible(false);
				deletePanelC.setVisible(false);
				
				LayoutManager ol_AlterarPanel = new OverlayLayout(alterarPanelC);
				alterarPanelC.setLayout(ol_AlterarPanel);
				JButton btnAlterar = new JButton("Alterar");
				alterarPanelC.add(btnAlterar);
				
				diagnosticoField = new JTextField();
				alterarPanelC.add(diagnosticoField);
				diagnosticoField.setText("Diagnostico");
				diagnosticoField.setColumns(10);
				diagnosticoField.setBounds(10, 49, 800, 33);
				
				horarioField = new JTextField();
				alterarPanelC.add(horarioField);
				horarioField.setText("00/00/0000 00:00");
				horarioField.setColumns(10);
				horarioField.setBounds(10, 88, 800, 33);
				
				valorField = new JTextField();
				alterarPanelC.add(valorField);
				valorField.setBounds(10, 127, 800, 33);
				valorField.setColumns(10);
				valorField.setText("Valor");
				
				alterarPanelC.setBounds(154, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(alterarPanelC);
				alterarPanelC.setLayout(null);
				
				comboConsulta = new JComboBox();
				comboConsulta.setBounds(10, 10, 800, 30);
				alterarPanelC.add(comboConsulta);
								
				List<Consulta> consultas = null;
				try {
					consultas = ConsultaDAO.getInstance().selectAllCon();
				} catch (SelectException e2) {
					e2.printStackTrace();
				} 
				comboConsulta.setModel(new ComboBoxModelAll(consultas));
							
				btnAlterar.addMouseListener(new MouseAdapter() {					
					@Override
					public void mouseClicked(MouseEvent e) {
					Consulta consulta = new Consulta();
					String aux;
					 aux = valorField.getText();
					 int valor = Integer.parseInt(aux);
					 consulta.setValor(valor);
					 aux = horarioField.getText();
					 
					 SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
						Date dataFormatada;
						try {
							dataFormatada = dtf.parse(aux);
							 consulta.getHorario().setTime(dataFormatada);
						} catch (ParseException e1) {
							System.out.println("erro de formatação da data");
							return;
						}
						consulta.setDiagnostico(diagnosticoField.getText());
					 
					sistema.alterarConsulta(consulta);	
					
					JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso !");
					alterarPanelC.setVisible(false);
					}
				});
				btnAlterar.setBounds(686, 422, 124, 40);				
			}
		});
		btnAlterarConsulta.setBounds(10, 398, 120, 30);
		frmHospitalSystem.getContentPane().add(btnAlterarConsulta);
		
		JButton btnExcluirPaciente = new JButton("Excluir Paciente");
		btnExcluirPaciente.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnExcluirPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarPanelP.setVisible(false);
				cadastrarPanelM.setVisible(false);
				cadastrarPanelC.setVisible(false);
				listarPanelP.setVisible(false);
				listarPanelM.setVisible(false);
				listarPanelC.setVisible(false);
				alterarPanelP.setVisible(false);
				alterarPanelM.setVisible(false);
				alterarPanelC.setVisible(false);
				deletePanelP.setVisible(true);
				deletePanelM.setVisible(false);
				deletePanelC.setVisible(false);
				
				LayoutManager overlay = new OverlayLayout(deletePanelP);
				deletePanelP.setLayout(overlay);
				JButton btnRemover = new JButton("Remover");
				deletePanelP.add(btnRemover);
				
				deletePanelP.setBounds(154, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(deletePanelP);
				deletePanelP.setLayout(null);
				
				comboPaciente = new JComboBox();
				comboPaciente.setBounds(10, 10, 330, 30);
				deletePanelP.add(comboPaciente);				
				
				List<Paciente> pacientes = null;
				try {
					pacientes = PacienteDAO.getInstance().selectAllPac();
				} catch (SelectException e2) {
					e2.printStackTrace();
				} 
				comboPaciente.setModel(new ComboBoxModelAll(pacientes));
				
				btnRemover.addMouseListener(new MouseAdapter() {					
					@Override
					public void mouseClicked(MouseEvent e) {
					Paciente paciente = new Paciente();
					paciente = (Paciente) comboPaciente.getModel().getSelectedItem();
											
					sistema.removerPaciente(paciente.getId());
					sistema.removerPessoa(paciente.getIdPes());
					
						JOptionPane.showMessageDialog(null, "Remoção efetuada com sucesso !");
						deletePanelP.setVisible(false);
					}
				});
				btnRemover.setBounds(686, 422, 124, 40);
			}
		});
		btnExcluirPaciente.setBounds(10, 439, 120, 30);
		frmHospitalSystem.getContentPane().add(btnExcluirPaciente);
		
		JButton btnExcluirMedico = new JButton("Ecluir Medico");
		btnExcluirMedico.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnExcluirMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarPanelP.setVisible(false);
				cadastrarPanelM.setVisible(false);
				cadastrarPanelC.setVisible(false);
				listarPanelP.setVisible(false);
				listarPanelM.setVisible(false);
				listarPanelC.setVisible(false);
				alterarPanelP.setVisible(false);
				alterarPanelM.setVisible(false);
				alterarPanelC.setVisible(false);
				deletePanelP.setVisible(false);
				deletePanelM.setVisible(true);
				deletePanelC.setVisible(false);
				
				LayoutManager overlay = new OverlayLayout(deletePanelM);
				deletePanelM.setLayout(overlay);
				JButton btnRemover = new JButton("Remover");
				deletePanelM.add(btnRemover);
				
				deletePanelM.setBounds(154, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(deletePanelM);
				deletePanelM.setLayout(null);
				
				comboMedico = new JComboBox();
				comboMedico.setBounds(10, 10, 330, 30);
				deletePanelM.add(comboMedico);
								
				List<Medico> medicos = null;
				try {
					medicos = MedicoDAO.getInstance().selectAllMed();
				} catch (SelectException e2) {
					e2.printStackTrace();
				} 
				comboMedico.setModel(new ComboBoxModelAll(medicos));
				
				btnRemover.addMouseListener(new MouseAdapter() {					
					@Override
					public void mouseClicked(MouseEvent e) {
					Medico medico = new Medico();
					medico = (Medico) comboMedico.getModel().getSelectedItem();					
					
					sistema.removerMedico(medico.getId());
					sistema.removerPessoa(medico.getIdPes());
					
						JOptionPane.showMessageDialog(null, "Remoção efetuada com sucesso !");
						deletePanelM.setVisible(false);
					}
				});
				btnRemover.setBounds(686, 422, 124, 40);
			}
		});
		btnExcluirMedico.setBounds(10, 480, 120, 30);
		frmHospitalSystem.getContentPane().add(btnExcluirMedico);
		
		JButton btnExcluirConsulta = new JButton("Excluir Consulta");
		btnExcluirConsulta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnExcluirConsulta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnExcluirConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarPanelP.setVisible(false);
				cadastrarPanelM.setVisible(false);
				cadastrarPanelC.setVisible(false);
				listarPanelP.setVisible(false);
				listarPanelM.setVisible(false);
				listarPanelC.setVisible(false);
				alterarPanelP.setVisible(false);
				alterarPanelM.setVisible(false);
				alterarPanelC.setVisible(false);
				deletePanelP.setVisible(false);
				deletePanelM.setVisible(false);
				deletePanelC.setVisible(true);
				
				
				LayoutManager overlay = new OverlayLayout(deletePanelC);
				deletePanelC.setLayout(overlay);
				JButton btnRemover = new JButton("Remover");
				deletePanelC.add(btnRemover);
				
				deletePanelC.setBounds(154, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(deletePanelC);
				deletePanelC.setLayout(null);
				
				comboConsulta = new JComboBox();
				comboConsulta.setBounds(10, 10, 800, 30);
				deletePanelC.add(comboConsulta);			
				
				List<Consulta> consulta = null;
				try {
					consulta = ConsultaDAO.getInstance().selectAllCon();
				} catch (SelectException e2) {
					e2.printStackTrace();
				} 
				comboConsulta.setModel(new ComboBoxModelAll(consulta));
				
				btnRemover.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
					Consulta consulta = new Consulta();
					consulta = (Consulta) comboConsulta.getModel().getSelectedItem();						
					
					sistema.removerConsulta(consulta.getId());
								
						JOptionPane.showMessageDialog(null, "Remoção efetuada com sucesso !");
						deletePanelC.setVisible(false);
					}
				});
				btnRemover.setBounds(686, 422, 124, 40);
			}
		});
		btnExcluirConsulta.setBounds(10, 521, 120, 30);
		frmHospitalSystem.getContentPane().add(btnExcluirConsulta);	
	}
		
		public void atualizaTabelaP(ArrayList<Paciente> lista) {
			limpaTabela(tblPacientes);
			String linha[] = new String[] {"", "", ""};
			try {
				DefaultTableModel dadosPac = (DefaultTableModel) tblPacientes.getModel();
				
				int pos = -1;
				for(Pessoa contribuinte : lista) {
					pos++;
					dadosPac.addRow(linha);
					dadosPac.setValueAt(contribuinte.getId(), pos, 0);
					dadosPac.setValueAt(contribuinte.getNome(), pos, 1);
					dadosPac.setValueAt(contribuinte.getCpf(), pos, 2);

				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erros: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		public void atualizaTabelaM(ArrayList<Medico> lista) {
			limpaTabela(tblMedicos);
			String linha[] = new String[] {"", "", ""};
			try {
				DefaultTableModel dadosMed = (DefaultTableModel) tblMedicos.getModel();
				
				int pos = -1;
				for(Pessoa pessoa : lista) {
					pos++;
					dadosMed.addRow(linha);
					dadosMed.setValueAt(pessoa.getId(), pos, 0);
					dadosMed.setValueAt(pessoa.getNome(), pos, 1);
					dadosMed.setValueAt(pessoa.getCpf(), pos, 2);

				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erros: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		public void atualizaTabelaC(ArrayList<Consulta> lista) {
			limpaTabela(tblConsultas);
			String linha[] = new String[] {"", "", "", "",""};
			try {
				DefaultTableModel dadosCon = (DefaultTableModel) tblConsultas.getModel();
				
				int pos = -1;
				for(Consulta consulta : lista) {
					pos++;
					dadosCon.addRow(linha);
					dadosCon.setValueAt(consulta.getId(), pos, 0);
					dadosCon.setValueAt(consulta.getValor(), pos, 1);
					dadosCon.setValueAt(consulta.getHorario().getTime(), pos, 2);
					dadosCon.setValueAt(consulta.getMedico().getId(), pos, 3);
					dadosCon.setValueAt(consulta.getPaciente().getId(), pos, 4);

				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erros: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			}
		}

		public void limpaTabela(JTable table) {
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	        while (dtm.getRowCount() > 0) {
	            dtm.removeRow(0);
	        }
		}
		
		public class ComboBoxModelAll extends javax.swing.DefaultComboBoxModel<Object> {
			public ComboBoxModelAll(java.util.List<? extends Object> c) {
			    Object[] elementData = c.toArray();
			    int size;
			    if ((size = elementData.length) != 0) {
			        if (elementData.getClass() != Object[].class) {
			            elementData = java.util.Arrays.copyOf(elementData, size, Object[].class);
			        }
			        for (Object ob : elementData) {
			            this.addElement(ob);
			        }
			    }
			}
		}
	}