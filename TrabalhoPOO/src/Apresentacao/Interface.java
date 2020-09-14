package Apresentacao;

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
import java.awt.GridLayout;
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
import Persistencia.MedicoDAO;
import Persistencia.PacienteDAO;
import exceptions.SelectException;
import javax.swing.JComboBox;

public class Interface {

	static Sistema sistema = new Sistema();
	
	private JFrame frmHospitalSystem;
	
	private JTextField valorField;
	private JTextField idadeField;
	private JTextField cpfField;
	private JTextField cidadeField;
	private JTextField descricaoField;
	
	JTable tblPacientes = new JTable();
	JTable tblMedicos = new JTable();
	JTable tblConsultas = new JTable();
	
	JComboBox comboMedico;
	JComboBox comboPaciente;
	

	private JTextField horarioField;
	private JTextField diagnosticoField;
	
	

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
		
			
		JButton btnCadastrarPaciente = new JButton("Cadastar Paciente");
		btnCadastrarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCadastrarPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel panel = new JPanel();
				panel.setVisible(true);
				
				LayoutManager overlay = new OverlayLayout(panel);
				panel.setLayout(overlay);
				JButton btnCadastrar = new JButton("Cadastrar");
				panel.add(btnCadastrar);
				
				
				panel.setBounds(140, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(panel);
				panel.setLayout(null);
				
				valorField = new JTextField();
				valorField.setBounds(10, 29, 800, 33);
				panel.add(valorField);
				valorField.setColumns(10);
				valorField.setText("Nome");
				
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
				
				btnCadastrar.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						Paciente paciente = new Paciente();
						 Pessoa pessoa = new Pessoa();
						 String aux;
						 
						 
						 pessoa.setNome(valorField.getText());
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
						panel.setVisible(false);
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
				JPanel panel = new JPanel();
				panel.setVisible(true);
				
				LayoutManager overlay = new OverlayLayout(panel);
				panel.setLayout(overlay);
				JButton btnCadastrar = new JButton("Cadastrar");
				panel.add(btnCadastrar);
				

				panel.setBounds(140, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(panel);
				panel.setLayout(null);
				
				valorField = new JTextField();
				valorField.setBounds(10, 29, 800, 33);
				panel.add(valorField);
				valorField.setColumns(10);
				valorField.setText("Nome");
				
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
				
				btnCadastrar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					   	 Medico medico = new Medico();
						 Pessoa pessoa = new Pessoa();
						 String aux;
						 
						 
						 pessoa.setNome(valorField.getText());
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
						panel.setVisible(false);
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
				
				comboMedico = new JComboBox();
				comboMedico.setBounds(166, 320, 330, 30);
				frmHospitalSystem.getContentPane().add(comboMedico);
				
				List<Medico> medicos = null;
				try {
					medicos = MedicoDAO.getInstance().selectAllMed();
				} catch (SelectException e2) {
					e2.printStackTrace();
				} 
				comboMedico.setModel(new ComboBoxModelAll(medicos));
				
				comboPaciente = new JComboBox();
				comboPaciente.setBounds(618, 320, 330, 30);
				frmHospitalSystem.getContentPane().add(comboPaciente);
				
				List<Paciente> pacientes = null;
				try {
					pacientes = PacienteDAO.getInstance().selectAllPac();
				} catch (SelectException e2) {
					e2.printStackTrace();
				} 
				comboPaciente.setModel(new ComboBoxModelAll(pacientes));
			
				
				JPanel panel_1 = new JPanel(new GridLayout(2, 2));
				panel_1.setVisible(true);
				
			
				LayoutManager ol_panel_1 = new OverlayLayout(panel_1);
				panel_1.setLayout(ol_panel_1);
				JButton btnCadastrar_1 = new JButton("Cadastrar");
				panel_1.add(btnCadastrar_1);
				
				panel_1.setBounds(140, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(panel_1);
				panel_1.setLayout(null);
				
				valorField = new JTextField();
				valorField.setBounds(10, 29, 800, 33);
				panel_1.add(valorField);
				valorField.setColumns(10);
				valorField.setText("Valor");
				
				horarioField = new JTextField();
				horarioField.setText("00/00/0000 00:00");
				horarioField.setColumns(10);
				horarioField.setBounds(10, 73, 800, 33);
				panel_1.add(horarioField);
				
				diagnosticoField = new JTextField();
				diagnosticoField.setText("Diagnostico");
				diagnosticoField.setColumns(10);
				diagnosticoField.setBounds(10, 117, 800, 108);
				panel_1.add(diagnosticoField);
				
				
				btnCadastrar_1.addMouseListener(new MouseAdapter() {
					
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
						panel_1.setVisible(false);
						comboMedico.setVisible(false);
						comboPaciente.setVisible(false);
					}
				});
				btnCadastrar_1.setBounds(686, 422, 124, 40);
				
				
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
				panel.setBounds(140, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(panel);
				panel.setLayout(null);
				
				

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
				panel.add(scrollPane);
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
				JPanel panel = new JPanel();
				panel.setBounds(140, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(panel);
				panel.setLayout(null);
				
				

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
				panel.add(scrollPane);
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
		btnExcluirPaciente.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnExcluirPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel deletePanel = new JPanel();
				deletePanel.setVisible(true);
				
				LayoutManager overlay = new OverlayLayout(deletePanel);
				deletePanel.setLayout(overlay);
				JButton btnRemover = new JButton("Remover");
				deletePanel.add(btnRemover);
				btnRemover.setVisible(true);
				
				deletePanel.setBounds(154, 70, 820, 481);
				frmHospitalSystem.getContentPane().add(deletePanel);
				deletePanel.setLayout(null);
				
				comboPaciente = new JComboBox();
				comboPaciente.setBounds(10, 10, 330, 30);
				deletePanel.add(comboPaciente);
				
				
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
						deletePanel.setVisible(false);
						btnRemover.setVisible(false);
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