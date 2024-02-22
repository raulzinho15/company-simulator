package application;

import java.io.*;
import javafx.concurrent.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ConsoleController {

	private Service<Void> backgroundThread;
	
	@FXML private Label lbl;
	@FXML private Label lblTxt;
	
	@FXML private AnchorPane anchor;
	
	private LabelEditor le;

	private BufferedReader br;
	private PrintWriter pw;
	private StringBuilder sb;

	private int history;
	private int inHistory = 0;
	
	private String line;
	private String line1 = "";
	private String line2 = "";
	private String line3 = "";
	private String line4 = "";
	private String line5 = "";
	private String line6 = "";
	private String line7 = "";
	private String line8 = "";
	private String line9 = "";
	private String line10 = "";
	
	private static long a = 1;
	
	private boolean admin = false;
	private boolean mouseScrolledUp = false;
	
	private long linesUp = 0;
	
	public void keyPressed(KeyEvent key) {
		try {
			if (key.getCode() == KeyCode.ENTER) {
				inHistory = 0;
				sb = new StringBuilder(lblTxt.getText().toLowerCase());
				for (int i = 0;i < sb.length();i++) {
					if (Character.toString(sb.charAt(i)).equals("|")) {
						sb.deleteCharAt(i);
					}
				}
				lblTxt.setText(sb.toString());
				history(sb.toString());
				if (lblTxt.getText().toLowerCase().equals("> /rauladmin") && !admin) {
					log("The user is now an admin.");
					admin = true;
				} else if (lblTxt.getText().toLowerCase().equals("> /reset") && admin) {
					pw = new PrintWriter("stats/console.stat");
					pw.println(1);
					pw.close();
					log("The user's data was reset.");
				} else if (lblTxt.getText().toLowerCase().equals("> /exit")) {
					pw = new PrintWriter("stats/console.stat");
					pw.println(1000);
					pw.close();
					log("SYSTEM TERMINATED");
					System.exit(0);
				} else if (lblTxt.getText().toLowerCase().equals("> /exit console")) {
					log("SYSTEM TERMINATED");
					Stage stage = (Stage)lbl.getScene().getWindow();
					stage.close();
				} else if (lblTxt.getText().toLowerCase().equals("> /clear")) {
					new File("stats/log.stat").delete();
					new File("stats/log.stat").createNewFile();
				} else if (lblTxt.getText().toLowerCase().equals("> /help")) {
					log("");
					log("Possible Commands:");
					log("/exit - Exits the game and console.");
					log("/exit console - Exits the console.");
					log("/clear - Clears the console.");
					log("/help - Lists possible commands.");
					if (admin) {
						log("/all [amount]");
						log("/resource [resource] [amount]");
						log("/worker [worker] [amount]");
						log("/money [amount]");
						log("/rank [number]");
						log("/play [song]");
						log("/reset");
					}
				} else if (lblTxt.getText().toLowerCase().equals("> /resource help") && admin) {
					log("");
					log("Possible Resources:");
					log("food");
					log("fish");
					log("stone");
					log("coal");
					log("wood");
					log("planks");
					log("crop");
					log("cotton");
					log("steak");
					log("pork");
					log("chicken");
					log("mutton");
				} else if (lblTxt.getText().toLowerCase().equals("> /worker help") && admin) {
					log("");
					log("Possible Workers:");
					log("rancher");
					log("fisher");
					log("fishmerchant");
					log("miner");
					log("coalminer");
					log("coalmerchant");
					log("lumberjack");
					log("woodcutter");
					log("plankmerchant");
					log("farmer");
					log("cottonfarmer");
					log("cottonmerchant");
					log("cowrancher");
					log("steakmerchant");
					log("pigrancher");
					log("porkmerchant");
					log("chickenrancher");
					log("chickenmerchant");
					log("sheeprancher");
					log("muttonmerchant");
				} else if (lblTxt.getText().toLowerCase().equals("> /play help") && admin) {
					log("");
					log("Possible Songs:");
					log("idle1");
					log("idle2");
					log("idle3");
				} else {
					sb = new StringBuilder(lblTxt.getText().toLowerCase());
					sb.setLength(7);
					if (sb.toString().equals("> /all ") && admin) {
						sb = new StringBuilder(lblTxt.getText().toLowerCase());
						sb.delete(0,7);
						log("Gave user "+sb.toString()+" of everything.");
						pw = new PrintWriter("stats/console.stat");
						pw.println(2);
						pw.println(Long.parseLong(sb.toString()));
						pw.close();
					} else {
						sb = new StringBuilder(lblTxt.getText().toLowerCase());
						sb.setLength(12);
						if (sb.toString().equals("> /resource ") && admin) {
							sb = new StringBuilder(lblTxt.getText().toLowerCase());
							sb.delete(0,12);
							sb.setLength(5);
							if (sb.toString().equals("food ")) {
								sb = new StringBuilder(lblTxt.getText().toLowerCase());
								sb.delete(0,17);
								log("Gave user "+sb.toString()+" Food.");
								pw = new PrintWriter("stats/console.stat");
								pw.println(3);
								pw.println(Long.parseLong(sb.toString()));
								pw.close();
							} else {
								sb = new StringBuilder(lblTxt.getText().toLowerCase());
								sb.delete(0,12);
								sb.setLength(5);
								if (sb.toString().equals("fish ")) {
									sb = new StringBuilder(lblTxt.getText().toLowerCase());
									sb.delete(0,17);
									log("Gave user "+sb.toString()+" Fish.");
									pw = new PrintWriter("stats/console.stat");
									pw.println(4);
									pw.println(Long.parseLong(sb.toString()));
									pw.close();
								} else {
									sb = new StringBuilder(lblTxt.getText().toLowerCase());
									sb.delete(0,12);
									sb.setLength(6);
									if (sb.toString().equals("stone ")) {
										sb = new StringBuilder(lblTxt.getText().toLowerCase());
										sb.delete(0,18);
										log("Gave user "+sb.toString()+" Stone.");
										pw = new PrintWriter("stats/console.stat");
										pw.println(5);
										pw.println(Long.parseLong(sb.toString()));
										pw.close();
									} else {
										sb = new StringBuilder(lblTxt.getText().toLowerCase());
										sb.delete(0,12);
										sb.setLength(5);
										if (sb.toString().equals("coal ")) {
											sb = new StringBuilder(lblTxt.getText().toLowerCase());
											sb.delete(0,17);
											log("Gave user "+sb.toString()+" Coal.");
											pw = new PrintWriter("stats/console.stat");
											pw.println(6);
											pw.println(Long.parseLong(sb.toString()));
											pw.close();
										} else {
											sb = new StringBuilder(lblTxt.getText().toLowerCase());
											sb.delete(0,12);
											sb.setLength(5);
											if (sb.toString().equals("wood ")) {
												sb = new StringBuilder(lblTxt.getText().toLowerCase());
												sb.delete(0,17);
												log("Gave user "+sb.toString()+" Wood.");
												pw = new PrintWriter("stats/console.stat");
												pw.println(7);
												pw.println(Long.parseLong(sb.toString()));
												pw.close();
											} else {
												sb = new StringBuilder(lblTxt.getText().toLowerCase());
												sb.delete(0,12);
												sb.setLength(7);
												if (sb.toString().equals("planks ")) {
													sb = new StringBuilder(lblTxt.getText().toLowerCase());
													sb.delete(0,19);
													log("Gave user "+sb.toString()+" Plank(s).");
													pw = new PrintWriter("stats/console.stat");
													pw.println(8);
													pw.println(Long.parseLong(sb.toString()));
													pw.close();
												} else {
													sb = new StringBuilder(lblTxt.getText().toLowerCase());
													sb.delete(0,12);
													sb.setLength(6);
													if (sb.toString().equals("crops ")) {
														sb = new StringBuilder(lblTxt.getText().toLowerCase());
														sb.delete(0,18);
														log("Gave user "+sb.toString()+" Crop(s).");
														pw = new PrintWriter("stats/console.stat");
														pw.println(9);
														pw.println(Long.parseLong(sb.toString()));
														pw.close();
													} else {
														sb = new StringBuilder(lblTxt.getText().toLowerCase());
														sb.delete(0,12);
														sb.setLength(7);
														if (sb.toString().equals("cotton ")) {
															sb = new StringBuilder(lblTxt.getText().toLowerCase());
															sb.delete(0,19);
															log("Gave user "+sb.toString()+" Cotton.");
															pw = new PrintWriter("stats/console.stat");
															pw.println(10);
															pw.println(Long.parseLong(sb.toString()));
															pw.close();
														} else {
															sb = new StringBuilder(lblTxt.getText().toLowerCase());
															sb.delete(0,12);
															sb.setLength(6);
															if (sb.toString().equals("steak ")) {
																sb = new StringBuilder(lblTxt.getText().toLowerCase());
																sb.delete(0,18);
																log("Gave user "+sb.toString()+" Steak.");
																pw = new PrintWriter("stats/console.stat");
																pw.println(24);
																pw.println(Long.parseLong(sb.toString()));
																pw.close();
															} else {
																sb = new StringBuilder(lblTxt.getText().toLowerCase());
																sb.delete(0,12);
																sb.setLength(5);
																if (sb.toString().equals("pork ")) {
																	sb = new StringBuilder(lblTxt.getText().toLowerCase());
																	sb.delete(0,17);
																	log("Gave user "+sb.toString()+" Pork.");
																	pw = new PrintWriter("stats/console.stat");
																	pw.println(25);
																	pw.println(Long.parseLong(sb.toString()));
																	pw.close();
																} else {
																	sb = new StringBuilder(lblTxt.getText().toLowerCase());
																	sb.delete(0,12);
																	sb.setLength(8);
																	if (sb.toString().equals("chicken ")) {
																		sb = new StringBuilder(lblTxt.getText().toLowerCase());
																		sb.delete(0,20);
																		log("Gave user "+sb.toString()+" Chicken.");
																		pw = new PrintWriter("stats/console.stat");
																		pw.println(26);
																		pw.println(Long.parseLong(sb.toString()));
																		pw.close();
																	} else {
																		sb = new StringBuilder(lblTxt.getText().toLowerCase());
																		sb.delete(0,12);
																		sb.setLength(7);
																		if (sb.toString().equals("mutton ")) {
																			sb = new StringBuilder(lblTxt.getText().toLowerCase());
																			sb.delete(0,19);
																			log("Gave user "+sb.toString()+" Mutton.");
																			pw = new PrintWriter("stats/console.stat");
																			pw.println(27);
																			pw.println(Long.parseLong(sb.toString()));
																			pw.close();
																		} else {
																			log("That is an invalid resource.");
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						} else {
							sb = new StringBuilder(lblTxt.getText().toLowerCase());
							sb.setLength(10);
							if (sb.toString().equals("> /worker ") && admin) {
								sb = new StringBuilder(lblTxt.getText().toLowerCase());
								sb.delete(0,10);
								sb.setLength(8);
								if (sb.toString().equals("rancher ")) {
									sb = new StringBuilder(lblTxt.getText().toLowerCase());
									sb.delete(0,18);
									log("Gave user "+sb.toString()+" Rancher(s).");
									pw = new PrintWriter("stats/console.stat");
									pw.println(11);
									pw.println(Long.parseLong(sb.toString()));
									pw.close();
								} else {
									sb = new StringBuilder(lblTxt.getText().toLowerCase());
									sb.delete(0,10);
									sb.setLength(7);
									if (sb.toString().equals("fisher ")) {
										sb = new StringBuilder(lblTxt.getText().toLowerCase());
										sb.delete(0,17);
										log("Gave user "+sb.toString()+" Fisher(s).");
										pw = new PrintWriter("stats/console.stat");
										pw.println(12);
										pw.println(Long.parseLong(sb.toString()));
										pw.close();
									} else {
										sb = new StringBuilder(lblTxt.getText().toLowerCase());
										sb.delete(0,10);
										sb.setLength(6);
										if (sb.toString().equals("miner ")) {
											sb = new StringBuilder(lblTxt.getText().toLowerCase());
											sb.delete(0,16);
											log("Gave user "+sb.toString()+" Miner(s).");
											pw = new PrintWriter("stats/console.stat");
											pw.println(13);
											pw.println(Long.parseLong(sb.toString()));
											pw.close();
										} else {
											sb = new StringBuilder(lblTxt.getText().toLowerCase());
											sb.delete(0,10);
											sb.setLength(10);
											if (sb.toString().equals("coalminer ")) {
												sb = new StringBuilder(lblTxt.getText().toLowerCase());
												sb.delete(0,20);
												log("Gave user "+sb.toString()+" Coal Miner(s).");
												pw = new PrintWriter("stats/console.stat");
												pw.println(14);
												pw.println(Long.parseLong(sb.toString()));
												pw.close();
											} else {
												sb = new StringBuilder(lblTxt.getText().toLowerCase());
												sb.delete(0,10);
												sb.setLength(11);
												if (sb.toString().equals("lumberjack ")) {
													sb = new StringBuilder(lblTxt.getText().toLowerCase());
													sb.delete(0,21);
													log("Gave user "+sb.toString()+" Lumberjack(s).");
													pw = new PrintWriter("stats/console.stat");
													pw.println(15);
													pw.println(Long.parseLong(sb.toString()));
													pw.close();
												} else {
													sb = new StringBuilder(lblTxt.getText().toLowerCase());
													sb.delete(0,10);
													sb.setLength(11);
													if (sb.toString().equals("woodcutter ")) {
														sb = new StringBuilder(lblTxt.getText().toLowerCase());
														sb.delete(0,21);
														log("Gave user "+sb.toString()+" Wood Cutter(s).");
														pw = new PrintWriter("stats/console.stat");
														pw.println(16);
														pw.println(Long.parseLong(sb.toString()));
														pw.close();
													} else {
														sb = new StringBuilder(lblTxt.getText().toLowerCase());
														sb.delete(0,10);
														sb.setLength(7);
														if (sb.toString().equals("farmer ")) {
															sb = new StringBuilder(lblTxt.getText().toLowerCase());
															sb.delete(0,17);
															log("Gave user "+sb.toString()+" Farmer(s).");
															pw = new PrintWriter("stats/console.stat");
															pw.println(17);
															pw.println(Long.parseLong(sb.toString()));
															pw.close();
														} else {
															sb = new StringBuilder(lblTxt.getText().toLowerCase());
															sb.delete(0,10);
															sb.setLength(13);
															if (sb.toString().equals("cottonfarmer ")) {
																sb = new StringBuilder(lblTxt.getText().toLowerCase());
																sb.delete(0,23);
																log("Gave user "+sb.toString()+" Cotton Farmer(s).");
																pw = new PrintWriter("stats/console.stat");
																pw.println(18);
																pw.println(Long.parseLong(sb.toString()));
																pw.close();
															} else {
																sb = new StringBuilder(lblTxt.getText().toLowerCase());
																sb.delete(0,10);
																sb.setLength(13);
																if (sb.toString().equals("fishmerchant ")) {
																	sb = new StringBuilder(lblTxt.getText().toLowerCase());
																	sb.delete(0,23);
																	log("Gave user "+sb.toString()+" Fish Merchant(s).");
																	pw = new PrintWriter("stats/console.stat");
																	pw.println(19);
																	pw.println(Long.parseLong(sb.toString()));
																	pw.close();
																} else {
																	sb = new StringBuilder(lblTxt.getText().toLowerCase());
																	sb.delete(0,10);
																	sb.setLength(13);
																	if (sb.toString().equals("coalmerchant ")) {
																		sb = new StringBuilder(lblTxt.getText().toLowerCase());
																		sb.delete(0,23);
																		log("Gave user "+sb.toString()+" Coal Merchant(s).");
																		pw = new PrintWriter("stats/console.stat");
																		pw.println(20);
																		pw.println(Long.parseLong(sb.toString()));
																		pw.close();
																	} else {
																		sb = new StringBuilder(lblTxt.getText().toLowerCase());
																		sb.delete(0,10);
																		sb.setLength(14);
																		if (sb.toString().equals("plankmerchant ")) {
																			sb = new StringBuilder(lblTxt.getText().toLowerCase());
																			sb.delete(0,24);
																			log("Gave user "+sb.toString()+" Plank Merchant(s).");
																			pw = new PrintWriter("stats/console.stat");
																			pw.println(21);
																			pw.println(Long.parseLong(sb.toString()));
																			pw.close();
																		} else {
																			sb = new StringBuilder(lblTxt.getText().toLowerCase());
																			sb.delete(0,10);
																			sb.setLength(15);
																			if (sb.toString().equals("cottonmerchant ")) {
																				sb = new StringBuilder(lblTxt.getText().toLowerCase());
																				sb.delete(0,25);
																				log("Gave user "+sb.toString()+" Cotton Merchant(s).");
																				pw = new PrintWriter("stats/console.stat");
																				pw.println(22);
																				pw.println(Long.parseLong(sb.toString()));
																				pw.close();
																			} else {
																				sb = new StringBuilder(lblTxt.getText().toLowerCase());
																				sb.delete(0,10);
																				sb.setLength(11);
																				if (sb.toString().equals("cowrancher ")) {
																					sb = new StringBuilder(lblTxt.getText().toLowerCase());
																					sb.delete(0,21);
																					log("Gave user "+sb.toString()+" Cow Rancher(s).");
																					pw = new PrintWriter("stats/console.stat");
																					pw.println(28);
																					pw.println(Long.parseLong(sb.toString()));
																					pw.close();
																				} else {
																					sb = new StringBuilder(lblTxt.getText().toLowerCase());
																					sb.delete(0,10);
																					sb.setLength(11);
																					if (sb.toString().equals("pigrancher ")) {
																						sb = new StringBuilder(lblTxt.getText().toLowerCase());
																						sb.delete(0,21);
																						log("Gave user "+sb.toString()+" Pig Rancher(s).");
																						pw = new PrintWriter("stats/console.stat");
																						pw.println(29);
																						pw.println(Long.parseLong(sb.toString()));
																						pw.close();
																					} else {
																						sb = new StringBuilder(lblTxt.getText().toLowerCase());
																						sb.delete(0,10);
																						sb.setLength(15);
																						if (sb.toString().equals("chickenrancher ")) {
																							sb = new StringBuilder(lblTxt.getText().toLowerCase());
																							sb.delete(0,25);
																							log("Gave user "+sb.toString()+" Chicken Rancher(s).");
																							pw = new PrintWriter("stats/console.stat");
																							pw.println(30);
																							pw.println(Long.parseLong(sb.toString()));
																							pw.close();
																						} else {
																							sb = new StringBuilder(lblTxt.getText().toLowerCase());
																							sb.delete(0,10);
																							sb.setLength(13);
																							if (sb.toString().equals("sheeprancher ")) {
																								sb = new StringBuilder(lblTxt.getText().toLowerCase());
																								sb.delete(0,23);
																								log("Gave user "+sb.toString()+" Sheep Rancher(s).");
																								pw = new PrintWriter("stats/console.stat");
																								pw.println(31);
																								pw.println(Long.parseLong(sb.toString()));
																								pw.close();
																							} else {
																								sb = new StringBuilder(lblTxt.getText().toLowerCase());
																								sb.delete(0,10);
																								sb.setLength(14);
																								if (sb.toString().equals("steakmerchant ")) {
																									sb = new StringBuilder(lblTxt.getText().toLowerCase());
																									sb.delete(0,24);
																									log("Gave user "+sb.toString()+" Steak Merchant(s).");
																									pw = new PrintWriter("stats/console.stat");
																									pw.println(32);
																									pw.println(Long.parseLong(sb.toString()));
																									pw.close();
																								} else {
																									sb = new StringBuilder(lblTxt.getText().toLowerCase());
																									sb.delete(0,10);
																									sb.setLength(13);
																									if (sb.toString().equals("porkmerchant ")) {
																										sb = new StringBuilder(lblTxt.getText().toLowerCase());
																										sb.delete(0,23);
																										log("Gave user "+sb.toString()+" Pork Merchant(s).");
																										pw = new PrintWriter("stats/console.stat");
																										pw.println(33);
																										pw.println(Long.parseLong(sb.toString()));
																										pw.close();
																									} else {
																										sb = new StringBuilder(lblTxt.getText().toLowerCase());
																										sb.delete(0,10);
																										sb.setLength(16);
																										if (sb.toString().equals("chickenmerchant ")) {
																											sb = new StringBuilder(lblTxt.getText().toLowerCase());
																											sb.delete(0,26);
																											log("Gave user "+sb.toString()+" Chicken Merchant(s).");
																											pw = new PrintWriter("stats/console.stat");
																											pw.println(34);
																											pw.println(Long.parseLong(sb.toString()));
																											pw.close();
																										} else {
																											sb = new StringBuilder(lblTxt.getText().toLowerCase());
																											sb.delete(0,10);
																											sb.setLength(15);
																											if (sb.toString().equals("muttonmerchant ")) {
																												sb = new StringBuilder(lblTxt.getText().toLowerCase());
																												sb.delete(0,25);
																												log("Gave user "+sb.toString()+" Mutton Merchant(s).");
																												pw = new PrintWriter("stats/console.stat");
																												pw.println(35);
																												pw.println(Long.parseLong(sb.toString()));
																												pw.close();
																											} else {
																												log("That is an invalid worker.");
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							} else {
								sb = new StringBuilder(lblTxt.getText().toLowerCase());
								sb.setLength(9);
								if (sb.toString().equals("> /money ") && admin) {
									sb = new StringBuilder(lblTxt.getText().toLowerCase());
									sb.delete(0,9);
									log("Gave user M$"+(long)Double.parseDouble(sb.toString())+".00.");
									pw = new PrintWriter("stats/console.stat");
									pw.println(23);
									pw.println((long)Double.parseDouble(sb.toString()));
									pw.close();
								} else {
									sb = new StringBuilder(lblTxt.getText().toLowerCase());
									sb.setLength(8);
									if (sb.toString().equals("> /rank ") && admin) {
										sb = new StringBuilder(lblTxt.getText().toLowerCase());
										sb.delete(0,8);
										log("Set user's rank to "+sb.toString()+".");
										pw = new PrintWriter("stats/console.stat");
										pw.println(36);
										pw.println(sb.toString());
										pw.close();
									} else {
										sb = new StringBuilder(lblTxt.getText().toLowerCase());
										sb.setLength(8);
										if (sb.toString().equals("> /play ") && admin) {
											sb = new StringBuilder(lblTxt.getText().toLowerCase());
											sb.delete(0,8);
											if (!sb.toString().equals("idle1") && !sb.toString().equals("idle2") && !sb.toString().equals("idle3")) error();
											else {
												log("Played "+sb.toString()+".wav.");
												pw = new PrintWriter("stats/console.stat");
												pw.println(37);
												pw.println(sb.toString());
												pw.close();
											}
										} else {
											error();
										}
									}
								}
							}
						}
					}
				}
				le.reset();
			} else if (key.getCode() == KeyCode.UP) {
				history = 1;
				br = new BufferedReader(new FileReader("stats/history.stat"));
				while (br.readLine() != null) {
					history++;
				}
				br.close();
				if (history-inHistory > 1) {
					inHistory++;
					String line = "";
					br = new BufferedReader(new FileReader("stats/history.stat"));
					for (int i = 0;i<history-inHistory;i++) {
						line = new TextEncryptor(br.readLine()).decrypt();
					}
					br.close();
					lblTxt.setText(line+"|");
					sb = new StringBuilder(lblTxt.getText());
					le.setCursorPos(sb.length());
				}
			} else if (key.getCode() == KeyCode.DOWN) {
				history = 1;
				br = new BufferedReader(new FileReader("stats/history.stat"));
				while (br.readLine() != null) {
					history++;
				}
				br.close();
				if (history-inHistory > 0 && inHistory > 0) {
					inHistory--;
					String line = "";
					br = new BufferedReader(new FileReader("stats/history.stat"));
					for (int i = 0;i<history-inHistory;i++) {
						line = new TextEncryptor(br.readLine()).decrypt();
					}
					br.close();
					if (inHistory != 0) {
						lblTxt.setText(line+"|");
						sb = new StringBuilder(lblTxt.getText());
						le.setCursorPos(sb.length());
					} else {
						le.reset();
					}
				}
			} else {
				le.insertChar(key);
			}
		} catch (Exception e) {}
	}
	
	public void keyReleased(KeyEvent key) {
		le.keyReleased(key);
	}
	
	public void space(ActionEvent event) {
		le.insertSpace();
	}
	
	public void log(String line) {
		try {
		pw = new PrintWriter(new FileWriter("stats/log.stat",true));
		pw.println(new TextEncryptor(line).encrypt());
		pw.close();
		} catch (Exception e) {}
	}
	
	public void history(String line) {
		try {
		pw = new PrintWriter(new FileWriter("stats/history.stat",true));
		pw.println(new TextEncryptor(line).encrypt());
		pw.close();
		} catch (Exception e) {}
	}
	
	public void error() {
		log("Invalid command...");
	}
	
	public void mouseScroll(ScrollEvent s) throws Exception {
		if (s.getDeltaY() > 0) {
			mouseScrolledUp = true;
			for (int i = 1;i <= s.getDeltaY()/40.0;i++) {
				br = new BufferedReader(new FileReader("stats/log.stat"));
				long logLength = 0;
				while (br.readLine() != null) logLength++;
				br.close();
				
				if (linesUp+11 <= logLength) {
					br = new BufferedReader(new FileReader("stats/log.stat"));
					for (int ii = 1;ii <= logLength-linesUp-11;ii++) br.readLine();
					line10 = line9;
					line9 = line8;
					line8 = line7;
					line7 = line6;
					line6 = line5;
					line5 = line4;
					line4 = line3;
					line3 = line2;
					line2 = line1;
					line1 = new TextEncryptor(br.readLine()).decrypt();
					lbl.setText(line1+"\n"+line2+"\n"+line3+"\n"+line4+"\n"+line5+"\n"+line6+"\n"+line7+"\n"+line8+"\n"+line9+"\n"+line10);
					linesUp++;
					br.close();
				}
			}
		} else {
			if (linesUp > 0) {
				br = new BufferedReader(new FileReader("stats/log.stat"));
				long logLength = 0;
				while (br.readLine() != null) logLength++;
				br.close();
				
				line1 = line2;
				line2 = line3;
				line3 = line4;
				line4 = line5;
				line5 = line6;
				line6 = line7;
				line7 = line8;
				line8 = line9;
				line9 = line10;
				
				br = new BufferedReader(new FileReader("stats/log.stat"));
				for (int ii = 0;ii < logLength-linesUp;ii++) br.readLine();
				line10 = new TextEncryptor(br.readLine()).decrypt();
				br.close();
				lbl.setText(line1+"\n"+line2+"\n"+line3+"\n"+line4+"\n"+line5+"\n"+line6+"\n"+line7+"\n"+line8+"\n"+line9+"\n"+line10);
				linesUp--;
			}
			if (linesUp == 0) mouseScrolledUp = false;
		}
	}

	public void mouseMoved(MouseEvent event) {
		backgroundThread = new Service<Void>() {
			@Override
			protected Task<Void> createTask() {
				return new Task<Void>() {
					@Override
					protected Void call() throws Exception {
						return null;
					}
				};
			}
		};
		backgroundThread.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent event) {
				try {
					if (!mouseScrolledUp) {
						line1 = "";
						line2 = "";
						line3 = "";
						line4 = "";
						line5 = "";
						line6 = "";
						line7 = "";
						line8 = "";
						line9 = "";
						line10 = "";
						br = new BufferedReader(new FileReader("stats/log.stat"));
						while ((line = br.readLine()) != null) {
							line1 = line2;
							line2 = line3;
							line3 = line4;
							line4 = line5;
							line5 = line6;
							line6 = line7;
							line7 = line8;
							line8 = line9;
							line9 = line10;
							line10 = new TextEncryptor(line).decrypt();
						}
						br.close();
						lbl.setText(line1+"\n"+line2+"\n"+line3+"\n"+line4+"\n"+line5+"\n"+line6+"\n"+line7+"\n"+line8+"\n"+line9+"\n"+line10);
					}
				} catch (Exception e) {}
				backgroundThread.restart();
			}
		});
		anchor.setOnMouseMoved(null);
		log("Type /help to show possible commands.");
		le = new LabelEditor(lblTxt, Integer.MAX_VALUE, "> ");
		backgroundThread.restart();
	}
	
	public static void test() {
		System.out.println(a);
		a++;
	}
}
