package org.traccar.protocol;

import org.junit.jupiter.api.Test;
import org.traccar.ProtocolTest;
import org.traccar.model.Position;

public class RstProtocolDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        var decoder = inject(new RstProtocolDecoder(null));

        verifyAttribute(decoder, text(
                "RST;A;RST-MINI-4Gv3;V9.10;009521405;1;134;FIM;"),
                Position.KEY_RESULT, "134");

        verifyAttribute(decoder, text(
                "RST;A;RST-MINIv5;V9.08;009767055;248;55;14-12-2023 19:34:20;14-12-2023 19:34:21;-12.923640;-38.388313;0;14;17;1;4;15;00;B0;00;1A;02;12.18;4.02;65;21;FE;0000;01;C0;001606017031;0002;FIM;"),
                Position.KEY_DRIVER_UNIQUE_ID, "001606017031");

        verifyNull(decoder, text(
                "RST;A;RST-MINIv2;V7.04;008051261;124;29;04-04-2021 17:27:26;04-04-2021 17:27:26;-1.280811;-47.931755;7353;79;1;14;7315;26;10;0;1855;0;0;0;0;5;5;-1.280821;-47.931747;04-04-2021 17:52:23;6;-1.280863;-47.931770;04-04-2021 18:12:19;5;-1.280844;-47.931763;04-04-2021 17:28:02;5;-1.280900;-47.931770;04-04-2021 19:04:27;4;-1.280843;-47.931747;04-04-2021 18:21:45;04-04-2021 19:29:59;04-04-2021 19:29:59;-1.280770;-47.931595;1;15;0;0;0;0;FIM;"));

        verifyAttribute(decoder, text(
                "RST;A;RST-MINI-4Gv3;V9.10;009521405;13;1;21-11-2023 20:04:18;21-11-2023 20:04:18;-12.923627;-38.388287;1;165;29;1;5;2;00;B0;00;1A;02;11.89;3.90;73;31;FE;0000;01;40;00800061;0;184;2;4;4;6;434.0000;2;0;-49;1815;37391;724;255;263;00000000;FIM;"),
                Position.KEY_IGNITION, true);

        verifyPosition(decoder, text(
                "RST;L;RST-MINIv2;V7.02;008068078;61;1;27-01-2020 21:36:33;27-01-2020 21:36:33;-16.696159;-49.284275;0;67;786;1;15;0;00;B0;00;19;06;12.42;4.16;79;20;FE;0000;01;E0;00800020;0;467;FIM;"));

        verifyAttribute(decoder, text(
                "RST;A;RST-MINIv2;V7.00;008033985;1;7;30-08-2019 11:31:38;30-08-2019 11:31:15;-23.645868;-46.637741;0;226;828;0;10;0;00;20;00;1A;02;0.02;3.40;0;0;FE;0000;04;80;11;0;FIM;"),
                Position.KEY_BATTERY, 3.40);

        verifyPosition(decoder, text(
                "RST;A;RST-MINIv2;V7.00;008033985;1;7;30-08-2019 11:31:38;30-08-2019 11:31:15;-23.645868;-46.637741;0;226;828;0;10;0;00;20;00;1A;02;0.02;3.40;0;0;FE;0000;04;80;11;0;FIM;"));

        verifyPosition(decoder, text(
                "RST;A;RST-MINIv2;V7.00;008033985;6;47;30-08-2019 19:01:13;30-08-2019 19:01:14;-23.645851;-46.637817;0;294;811;1;11;0;00;30;00;1A;02;3.82;4.16;0;0;FE;0000;02;40;71;000001F60A55;FIM;"));

    }

}
