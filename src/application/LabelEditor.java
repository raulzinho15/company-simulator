package application;

import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.input.Clipboard;
import javafx.scene.paint.*;

public class LabelEditor {
	
	public boolean shiftPress;
	public boolean controlPress;
	public boolean capsPress;
	public boolean allSelected;
	public boolean atMaxLength;

	public int maxLength;
	public int startingLength = 0;

	public int cursorPos;
	
	public Label label;
	
	private String starting = "";

	private StringBuilder sb;
	
	private Clipboard clipboard;

	public LabelEditor(Label lblName, int maxLength) {
		this.cursorPos = 1;
		this.maxLength = maxLength;
		this.label = lblName;
		this.shiftPress = false;
		this.controlPress = false;
		this.capsPress = false;
		this.allSelected = false;
		if (maxLength == 1) {
			this.atMaxLength = true;
		} else {
			this.atMaxLength = false;
		}
	    clipboard = Clipboard.getSystemClipboard();
	}

	public LabelEditor(Label lblName, int maxLength, String start) {
		starting = start;
		sb = new StringBuilder(starting);
		startingLength = sb.length();
		this.cursorPos = 1+startingLength;
		this.maxLength = maxLength;
		this.label = lblName;
		this.shiftPress = false;
		this.controlPress = false;
		this.capsPress = false;
		this.allSelected = false;
		if (maxLength == 1) {
			this.atMaxLength = true;
		} else {
			this.atMaxLength = false;
		}
	    clipboard = Clipboard.getSystemClipboard();
	}
	
	public boolean isAtMaxLength() {
		return atMaxLength;
	}

	public void setAtMaxLength(boolean atMaxLength) {
		this.atMaxLength = atMaxLength;
	}
	
	public boolean isShiftPress() {
		return shiftPress;
	}

	public void setShiftPress(boolean shiftPress) {
		this.shiftPress = shiftPress;
	}

	public boolean isControlPress() {
		return controlPress;
	}

	public void setControlPress(boolean controlPress) {
		this.controlPress = controlPress;
	}

	public boolean isCapsPress() {
		return capsPress;
	}

	public void setCapsPress(boolean capsPress) {
		this.capsPress = capsPress;
	}

	public boolean isAllSelected() {
		return allSelected;
	}

	public void setAllSelected(boolean allSelected) {
		this.allSelected = allSelected;
	}

	public long getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public int getCursorPos() {
		return this.cursorPos;
	}

	public void setCursorPos(int cursorPos) {
		this.cursorPos = cursorPos;
	}
	
	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}
	
	public String getStarting() {
		return starting;
	}

	public void setStarting(String starting) {
		this.starting = starting;
	}
	
	public int getStartingLength() {
		return startingLength;
	}

	public void setStartingLength(int startingLength) {
		this.startingLength = startingLength;
	}

	public void insertSpace() {
		if (this.cursorPos == 1+startingLength && this.label.getText().equals(starting+"|")) {
			cursorPos = 2+startingLength;
			this.label.setText(starting+" |");
		} else if (this.cursorPos == 1+startingLength && !this.label.getText().equals(starting+"|")) {
			cursorPos = 2+startingLength;
			sb = new StringBuilder(this.label.getText());
			sb.insert(startingLength, " ");
			this.label.setText(sb.toString());
		} else {
			sb = new StringBuilder(this.label.getText());
			sb.insert(this.cursorPos-1, " ");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		}
	}
	
	public void insertChar(KeyEvent key) {
		sb = new StringBuilder(this.label.getText());
		if (key.getCode() == KeyCode.ESCAPE) {
			System.exit(0);
		} else if (key.getCode() == KeyCode.SHIFT) {
			this.shiftPress = true;
		} else if (key.getCode() == KeyCode.CONTROL) {
			this.controlPress = true;
		} else if (key.getCode() == KeyCode.CAPS) {
			if (this.capsPress) {
				this.capsPress = false;
			} else {
				this.capsPress = true;
			}
		} else if (key.getCode() == KeyCode.BACK_SPACE) {
			if (this.allSelected) {
				this.label.setText(starting+"|");
				this.cursorPos = 1+startingLength;
				this.allSelected = false;
				this.label.setTextFill(Color.web("#ffffff"));
			} else {
				if (this.cursorPos > 1+startingLength) {
					sb.deleteCharAt(this.cursorPos-2);
					this.label.setText(sb.toString());
					this.cursorPos -= 1;
				}
			}
		} else if (key.getCode() == KeyCode.SEMICOLON && !this.shiftPress) {
			sb.insert(this.cursorPos-1, ";");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.SEMICOLON && this.shiftPress) {
			sb.insert(this.cursorPos-1, ":");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.COMMA && !this.shiftPress) {
			sb.insert(this.cursorPos-1, ",");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.PERIOD && !this.shiftPress) {
			sb.insert(this.cursorPos-1, ".");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.SLASH && this.shiftPress) {
			sb.insert(this.cursorPos-1, "?");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.SLASH && !this.shiftPress) {
			sb.insert(this.cursorPos-1, "/");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT1 && !this.shiftPress) {
			sb.insert(this.cursorPos-1, "1");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT1 && this.shiftPress) {
			sb.insert(this.cursorPos-1, "!");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT2 && !this.shiftPress) {
			sb.insert(this.cursorPos-1, "2");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT2 && this.shiftPress) {
			sb.insert(this.cursorPos-1, "@");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT3 && !this.shiftPress) {
			sb.insert(this.cursorPos-1, "3");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT3 && this.shiftPress) {
			sb.insert(this.cursorPos-1, "#");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT4 && !this.shiftPress) {
			sb.insert(this.cursorPos-1, "4");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT4 && this.shiftPress) {
			sb.insert(this.cursorPos-1, "$");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT5 && !this.shiftPress) {
			sb.insert(this.cursorPos-1, "5");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT5 && this.shiftPress) {
			sb.insert(this.cursorPos-1, "%");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT6 && !this.shiftPress) {
			sb.insert(this.cursorPos-1, "6");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT6 && this.shiftPress) {
			sb.insert(this.cursorPos-1, "^");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT7 && !this.shiftPress) {
			sb.insert(this.cursorPos-1, "7");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT7 && this.shiftPress) {
			sb.insert(this.cursorPos-1, "&");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT8 && !this.shiftPress) {
			sb.insert(this.cursorPos-1, "8");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT8 && this.shiftPress) {
			sb.insert(this.cursorPos-1, "*");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT9 && !this.shiftPress) {
			sb.insert(this.cursorPos-1, "9");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT9 && this.shiftPress) {
			sb.insert(this.cursorPos-1, "(");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.DIGIT0 && !this.shiftPress) {
			sb.insert(this.cursorPos-1, "0");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.BACK_QUOTE && !this.shiftPress) {
			sb.insert(this.cursorPos-1, "`");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.BACK_QUOTE && this.shiftPress) {
			sb.insert(this.cursorPos-1, "~");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.MINUS && !this.shiftPress) {
			sb.insert(this.cursorPos-1, "-");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.MINUS && this.shiftPress) {
			sb.insert(this.cursorPos-1, "_");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.QUOTE && !this.shiftPress) {
			sb.insert(this.cursorPos-1, "'");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.QUOTE && this.shiftPress) {
			sb.insert(this.cursorPos-1, "\"");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.SPACE && this.shiftPress) {
			sb.insert(this.cursorPos-1, " ");
			this.label.setText(sb.toString());
			this.cursorPos += 1;
		} else if (key.getCode() == KeyCode.A && this.controlPress && !this.shiftPress) {
			this.label.setTextFill(Color.web("#4800ff"));
			this.allSelected = true;
		} else if (key.getCode() == KeyCode.C && this.controlPress && this.allSelected && !this.shiftPress) {
			sb = new StringBuilder(this.label.getText());
			sb.delete(0,startingLength);
		    ClipboardContent content = new ClipboardContent();
		    content.putString(sb.toString());
		    clipboard.setContent(content);
		} else if (key.getCode() == KeyCode.V && this.controlPress && this.allSelected && !this.shiftPress) {
		    this.label.setText(starting+clipboard.getString());
		    this.allSelected = false;
			this.label.setTextFill(Color.web("#ffffff"));
		} else if (key.getCode() == KeyCode.V && this.controlPress && !this.allSelected && !this.shiftPress) {
			sb.deleteCharAt(this.cursorPos-1);
		    sb.insert(this.cursorPos-1, clipboard.getString());
		    cursorPos += clipboard.getString().length()-1;
		    this.label.setText(sb.toString());
		} else if (key.getCode() == KeyCode.LEFT) {
			if (this.cursorPos > 1) {
				sb.insert(this.cursorPos-2, "|");
				sb.deleteCharAt(this.cursorPos);
				this.label.setText(sb.toString());
				this.cursorPos -= 1;
				if (this.allSelected) {
					this.allSelected = false;
					this.label.setTextFill(Color.web("#ffffff"));
				}
			}
		} else if (key.getCode() == KeyCode.RIGHT) {
			if (this.cursorPos <= lblLength(this.label)-1) {
				sb.insert(this.cursorPos+1, "|");
				sb.deleteCharAt(this.cursorPos-1);
				this.label.setText(sb.toString());
				this.cursorPos += 1;
				if (this.allSelected) {
					this.allSelected = false;
					this.label.setTextFill(Color.web("#ffffff"));
				}
			}
		} else if (key.getCode() == KeyCode.HOME) {
			sb.insert(0, "|");
			sb.deleteCharAt(this.cursorPos);
			this.label.setText(sb.toString());
			this.cursorPos = 1+startingLength;
			if (this.allSelected) {
				this.allSelected = false;
				this.label.setTextFill(Color.web("#ffffff"));
			}
		} else if (key.getCode() == KeyCode.END) {
			sb.insert(lblLength(this.label), "|");
			sb.deleteCharAt(this.cursorPos-1);
			this.label.setText(sb.toString());
			if (this.allSelected) {
				this.allSelected = false;
				this.label.setTextFill(Color.web("#ffffff"));
			}
			this.cursorPos = lblLength(this.label); 
		} else {
			if (this.shiftPress || this.capsPress) {
				sb.insert(this.cursorPos-1, key.getCode());
				this.label.setText(sb.toString());
				this.cursorPos += 1;
			} else {
				sb.insert(this.cursorPos-1, key.getCode().toString().toLowerCase());
				this.label.setText(sb.toString());
				this.cursorPos += 1;
			}
		}
	}	
	
	public void keyReleased(KeyEvent key) {
		if (key.getCode() == KeyCode.SHIFT) {
			this.shiftPress = false;
		} else if (key.getCode() == KeyCode.CONTROL) {
			this.controlPress = false;
		}
	}
	
	public int lblLength(Label lbl) {
		return lbl.getText().length()+startingLength;
	}
	
	public void reset() {
		this.label.setText(starting+"|");
		this.cursorPos = startingLength+1;
	}
	
}
