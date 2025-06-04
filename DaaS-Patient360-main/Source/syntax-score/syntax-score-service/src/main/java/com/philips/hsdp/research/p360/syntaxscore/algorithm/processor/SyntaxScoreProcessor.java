/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.processor;

import org.springframework.stereotype.Service;

/* @author Sunil Kumar */
@Service
public abstract class SyntaxScoreProcessor {
	private int processorSkipCount = 0;
	protected SyntaxScoreProcessor nextSyntaxScoreProcessor;
	private boolean skipCurrentProcessor;

	public void getNextSyntexScoreProcessor() {
	}

	SyntaxScoreProcessor() {
		skipCurrentProcessor = false;
	}

	public void setSkipCurrentProcessor(boolean bSkipCurrentProcessor) {
		this.skipCurrentProcessor = bSkipCurrentProcessor;
	}

	public void setSkipCurrentProcessor(int nextNumberOfProcessSkipped) {
		processorSkipCount = nextNumberOfProcessSkipped;
	}

	public boolean isCurrentProcessorSkipped() {
		// ProcessorSkipCount; -- if 0 - process is not skipped -- if non-zero --
		// process is skipped
		if (processorSkipCount > 0) {
			// then
			processorSkipCount--;
			skipCurrentProcessor = true;
		} else {
			skipCurrentProcessor = false;
		}
		return skipCurrentProcessor;
	}

	public void setNextprocess(SyntaxScoreProcessor nextSyntaxScoreProcessor) {
		this.nextSyntaxScoreProcessor = nextSyntaxScoreProcessor;
	}

	public void process() {
		if (nextSyntaxScoreProcessor != null) {
			this.nextSyntaxScoreProcessor.process();
		}
		
	}
   //Abstract method 
	public abstract void calculateSyntaxScoreLeftDominance();
	//Abstract method
	public abstract void calculateSyntaxScoreRightDominance();
}