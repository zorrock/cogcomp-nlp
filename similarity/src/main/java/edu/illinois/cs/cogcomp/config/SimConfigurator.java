/**
 * This software is released under the University of Illinois/Research and Academic Use License. See
 * the LICENSE file in the root folder for details. Copyright (c) 2016
 *
 * Developed by: The Cognitive Computation Group University of Illinois at Urbana-Champaign
 * http://cogcomp.cs.illinois.edu/
 */
package edu.illinois.cs.cogcomp.config;

import edu.illinois.cs.cogcomp.core.utilities.configuration.Configurator;
import edu.illinois.cs.cogcomp.core.utilities.configuration.Property;
import edu.illinois.cs.cogcomp.core.utilities.configuration.ResourceManager;

public class SimConfigurator extends Configurator {
	public static final Property PHRASE_DICT = new Property("phrase_dict", "data/phrases");
	public static final Property VERB_PHRASES = new Property("verb_phrases", "data/verb_phrases");
	public static final Property USE_NE_COMPARISON = new Property("useNES", Configurator.FALSE);
	public static final Property USE_PHRASE_COMPARISON = new Property("usePhraseSim", Configurator.FALSE);
	public static final Property USE_SIMPLE_SCORE = new Property("useSimpleScore", Configurator.FALSE);
	public static final Property STOPWORD_FILE = new Property("stopwordFile", "llmStopwords.txt");
	public static final Property WORD_METRIC = new Property("wordMetric", "wordnet");
	public static final Property WORD_ENTAILMENT_THRESHOLD = new Property("wordEntailmentThreshold", "0.001");
	public static final Property LLM_ENTAILMENT_THRESHOLD = new Property("llmThreshold", "0.5");
	public static final Property WORD2VEC = new Property("word2vec", "data/word2vec.txt");
	public static final Property PARAGRAM = new Property("paragram", "data/paragram_vectors.txt");
	public static final Property GLOVE = new Property("glove", "data/glove.txt");
	public static final Property PHRASE2VEC = new Property("phrase2vec", "data/phrase2vec.txt");
	public static final Property MEMORYBASEDESA = new Property("memorybasedESA", "data/memorybasedESA.txt");
	public static final Property PARAGRAM_DIM = new Property("paragram_dim", "25");
	public static final Property PAGE_ID_MAPPING = new Property("pageIDMapping", "data/pageIDMapping.txt");
	public static final Property EMBEDDING_DIM = new Property("embedding_dim", "200");

	@Override
	public ResourceManager getDefaultConfig() {
		Property[] props = { WORD2VEC, PARAGRAM, GLOVE, PHRASE2VEC, MEMORYBASEDESA, PARAGRAM_DIM, PAGE_ID_MAPPING,
				EMBEDDING_DIM, USE_NE_COMPARISON, USE_PHRASE_COMPARISON, USE_SIMPLE_SCORE, STOPWORD_FILE, WORD_METRIC,
				WORD_ENTAILMENT_THRESHOLD, LLM_ENTAILMENT_THRESHOLD };
		return new ResourceManager(generateProperties(props));
	}

	public ResourceManager metricsConfig(String metrics, String file) throws Exception {
		Property metric = new Property("wordMetric", metrics);
		Property[] props = { metric };
		ResourceManager rm_ = new ResourceManager(generateProperties(props));
		return super.mergeProperties(new ResourceManager(file), rm_);
	}

}
