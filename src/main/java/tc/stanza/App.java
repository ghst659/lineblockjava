package tc.stanza;

import tc.fsm.Machine;

import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        final String[] LINES = {
            "", "", "",
            "Full fathom five thy father lies;",
            "Of his bones are coral made;",
            "Those are pearls that were his eyes:",
            "Nothing of him that doth fade,",
            "", "", "",
            "But doth suffer a sea-change",
            "Into something rich and strange.",
            "",
            "Sea-nymphs hourly ring his knell:",
            "Ding-dong.",
            "Hark! now I hear them—Ding-dong, bell."
        };
        List<List<String>> stanzas = ParseStanzas(LINES);
        for (List<String> stanza: stanzas) {
            for (String line: stanza) {
                System.out.println(line.trim());
            }
            System.out.println("-------------------");
        }
    }
    public static List<List<String>> ParseStanzas(final String[] LINES) {
        List<List<String>> result = new LinkedList<>();
        ParseBuffer buf = new ParseBuffer();
        Machine<String,List<String>> dut = new Machine<>(new OuterState(buf), new InnerState(buf));
        List<String> stanza = null;
        for (String line : LINES) {
            stanza = dut.process(line);
            if (stanza != null) {
                result.add(stanza);
            }
        }
        stanza = buf.closeStanza();
        if (stanza != null) {
            result.add(stanza);
        }
        return result;
    }
}
