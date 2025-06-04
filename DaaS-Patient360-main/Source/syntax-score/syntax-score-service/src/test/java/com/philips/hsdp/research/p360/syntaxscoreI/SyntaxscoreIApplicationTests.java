/*
 * (C) Koninklijke Philips Electronics N.V. 2021
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscoreI;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.philips.hsdp.research.p360.syntaxscore.SyntaxscoreIApplication;

@RunWith(MockitoJUnitRunner.class)
class SyntaxscoreIApplicationTests {

	@Mock
    private SyntaxscoreIApplication syntaxscoreIApplication;
	@Test
    void main() {
		SyntaxscoreIApplication.main(new String[] {});
        assertTrue(true);
    }
}
