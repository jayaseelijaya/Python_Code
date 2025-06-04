/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl;

import org.springframework.stereotype.Component;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.AortoOstialProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.BifurcationAngulationlt70Processor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.BifurcationMedinaProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.BifurcationProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.BluntStumpProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.BridgingProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.FirstSegmentProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.FirstSegmentVisualizedProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.HeavyCalcificationProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.LengthGT20mmProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.SelectedSegmentsProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.SeverTortuosityProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.SidebranchProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.LesionSubScoreProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.SyntaxScoreProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.ThrombusProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.TotalOcclusionAgeProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.TotalOcclusionProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.TrifurcationDiseasedSegmentsProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.TrifurcationProcessor;

/* @author Sunil Kumar */
@Component
public class CalculateSyntaxScoreLeftDominance{

	public SyntaxScoreProcessor getChainOfSyntaxScoreProcessor() {

		//hasmap processor name and processor object-create staticly
		
		SyntaxScoreProcessor selectedSegmentsProcessor = new SelectedSegmentsProcessor();
		SyntaxScoreProcessor totalOcclusionProcessor = new TotalOcclusionProcessor();
		SyntaxScoreProcessor firstSegmentProcessor = new FirstSegmentProcessor();
		SyntaxScoreProcessor totalOcclusionAgeProcessor = new TotalOcclusionAgeProcessor();
		SyntaxScoreProcessor bluntStumpProcessor = new BluntStumpProcessor();
		SyntaxScoreProcessor bridgingProcessor = new BridgingProcessor();
		SyntaxScoreProcessor firstSegmentVisualizedProcessor = new FirstSegmentVisualizedProcessor();
		SyntaxScoreProcessor sidebranchProcessor = new SidebranchProcessor();		
		SyntaxScoreProcessor trifurcationProcessor = new TrifurcationProcessor();
		SyntaxScoreProcessor trifurcationDiseasedSegmentsProcessor=new TrifurcationDiseasedSegmentsProcessor();
		SyntaxScoreProcessor bifurcationProcessor = new BifurcationProcessor();
		SyntaxScoreProcessor bifurcationMedinaProcessor = new BifurcationMedinaProcessor();
		SyntaxScoreProcessor bifurcationAngulationlt70Processor = new BifurcationAngulationlt70Processor();
		SyntaxScoreProcessor aortoOstialProcessor = new AortoOstialProcessor();
		SyntaxScoreProcessor severTortuosityProcessor = new SeverTortuosityProcessor();
		SyntaxScoreProcessor lengthGT20mmProcessor = new LengthGT20mmProcessor();
		SyntaxScoreProcessor heavyCalcificationProcessor = new HeavyCalcificationProcessor();
		SyntaxScoreProcessor thrombusProcessor = new ThrombusProcessor();
		SyntaxScoreProcessor lesionsubScoreProcessor = new LesionSubScoreProcessor();

		selectedSegmentsProcessor.setNextprocess(totalOcclusionProcessor);
		totalOcclusionProcessor.setNextprocess(firstSegmentProcessor);
		firstSegmentProcessor.setNextprocess(totalOcclusionAgeProcessor);
		totalOcclusionAgeProcessor.setNextprocess(bluntStumpProcessor);
		bluntStumpProcessor.setNextprocess(bridgingProcessor);
		bridgingProcessor.setNextprocess(firstSegmentVisualizedProcessor);
		firstSegmentVisualizedProcessor.setNextprocess(sidebranchProcessor);
		sidebranchProcessor.setNextprocess(trifurcationProcessor);
		trifurcationProcessor.setNextprocess(trifurcationDiseasedSegmentsProcessor);
		trifurcationDiseasedSegmentsProcessor.setNextprocess(bifurcationProcessor);
		bifurcationProcessor.setNextprocess(bifurcationMedinaProcessor);
		bifurcationMedinaProcessor.setNextprocess(bifurcationAngulationlt70Processor);
		bifurcationAngulationlt70Processor.setNextprocess(aortoOstialProcessor);
		aortoOstialProcessor.setNextprocess(severTortuosityProcessor);
		severTortuosityProcessor.setNextprocess(lengthGT20mmProcessor);
		lengthGT20mmProcessor.setNextprocess(heavyCalcificationProcessor);
		heavyCalcificationProcessor.setNextprocess(thrombusProcessor);
		thrombusProcessor.setNextprocess(lesionsubScoreProcessor);
		lesionsubScoreProcessor.setNextprocess(null);
		
		return selectedSegmentsProcessor;
	}
}