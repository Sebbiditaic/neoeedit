package neoe.ne.obsolete;

import javax.swing.JPanel;
import neoe.ne.EditorPanel;
import neoe.ne.EditorPanelConfig;
import neoe.ne.PageData;
import neoe.ne.U;

public class TopCoderEditorPlugin {
  EditorPanel editor;

  public JPanel getEditorPanel() {
    try {
      editor = new EditorPanel(EditorPanelConfig.DEFAULT);
      editor.getPage().ui.applyColorMode(1);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return editor;
  }

  public String getSource() {
    if (editor != null) {
      PageData pd = editor.getPage().pageData;
      return U.exportString(pd.lines, pd.lineSep);
    }
    return null;
  }

  public void setSource(String s) {
    if (editor != null) {
      editor.getPage().pageData.setText(s);
      editor.revalidate();
      editor.repaint();
    }
  }
}
