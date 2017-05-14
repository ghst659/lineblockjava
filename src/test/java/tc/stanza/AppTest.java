package tc.stanza;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AppTest {
    @Test
    public void testApp() {
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
        List<List<String>> stanzas = App.ParseStanzas(LINES);
        Assert.assertEquals(3, stanzas.size());
        Assert.assertEquals(4, stanzas.get(0).size());
        Assert.assertEquals(2, stanzas.get(1).size());
        Assert.assertEquals(3, stanzas.get(2).size());
    }
}
