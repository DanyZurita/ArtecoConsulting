package edu.elsmancs.arteco;


import org.junit.Test;

import org.junit.Assert;



public class ArtecoConsultingTest {

	@Test
    public void testMockURL() {
		String originalLorem = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sed velit a ante eleifend condimentum quis ac nisi. Praesent at viverra ex. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Sed fringilla enim erat, vitae egestas mauris auctor eu. Ut viverra iaculis orci non posuere. Cras pretium enim posuere ligula auctor, ac hendrerit sapien mattis. In placerat, risus vitae placerat fringilla, ante velit lobortis urna, sit amet facilisis augue nisi id ipsum. Fusce nisl dui, eleifend id aliquam eu, laoreet nec dolor.</p><p> Integer dictum mi id magna malesuada, eu congue orci facilisis. Aliquam lacus lorem, tincidunt et venenatis eu, dapibus quis velit. Nulla efficitur metus sed tellus dictum, in condimentum urna dignissim. Nulla nec tellus mauris. Duis quis sodales quam. Cras vestibulum rutrum libero. Nullam efficitur tincidunt tellus ut mollis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Fusce elementum et orci ac ultricies. Integer placerat tempus fringilla. Praesent rhoncus magna odio, sit amet eleifend felis hendrerit a. Phasellus commodo sodales metus vulputate luctus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec pretium finibus porttitor.</p><p> Nunc aliquam, orci sed lacinia dignissim, nulla purus molestie urna, quis fermentum leo massa at elit. Nunc dolor mi, sollicitudin a turpis nec, molestie mattis nunc. Curabitur pellentesque sapien purus, vitae blandit mi porta quis. Sed ac eros et arcu suscipit fringilla. In ornare quam nunc, quis imperdiet lacus pretium at. Nulla facilisi. Pellentesque eu posuere ex. Nam ac malesuada ante, a laoreet metus. Pellentesque sodales eleifend fringilla. Duis nec elementum massa.</p><p> Cras volutpat facilisis ante. Phasellus gravida lobortis ligula vitae aliquam. Quisque vitae arcu eget dui faucibus lobortis id id ipsum. Aliquam nunc erat, imperdiet vitae tempor id, ornare in tellus. Aenean ut tellus ut sapien consectetur ultrices. Nullam ullamcorper aliquet nibh, eget placerat augue venenatis sed. Proin maximus vestibulum pretium. Nulla vel dictum eros. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Maecenas condimentum sollicitudin mauris sed egestas. Phasellus volutpat purus ut lorem dictum porttitor. Integer augue velit, bibendum a metus vitae, rhoncus luctus dolor. Curabitur et tellus non dolor fermentum dapibus sit amet sagittis nulla. Etiam orci dui, finibus id velit ut, dictum malesuada ante. Maecenas egestas suscipit ligula, sed porta lectus cursus quis.</p><p> Mauris ipsum urna, aliquet id convallis sed, finibus et felis. Aliquam accumsan leo lectus, at placerat ex consequat et. Integer efficitur ultrices nibh, quis imperdiet ligula volutpat at. Vivamus vitae nibh id nulla iaculis dapibus sit amet vitae nulla. Nulla finibus tristique elit, eu pharetra tellus consectetur et. Duis sed dolor tempor, eleifend justo sed, condimentum eros. Nam magna neque, volutpat id varius non, maximus quis dui. Duis efficitur porttitor mauris at laoreet. Duis rhoncus eget neque semper commodo. Nulla quis erat et metus iaculis iaculis nec at orci.</p>";
		String actualLorem = Crawler.mockURL();
		Assert.assertEquals(originalLorem, actualLorem);
	}
	
	@Test
    public void testTotalWords() {
		String ejemplo = "Esto es un texto de ejemplo para el caso test de contar palabras.";
		Integer actualTotalWords = Logica.totalWords(ejemplo);
		Assert.assertEquals(13, actualTotalWords, 0d);
	}
	
	@Test
    public void testTotalPhrases() {
		String ejemplo = "Esto es. Un texto de ejemplo. Para el caso test. De contar palabras.";
		Integer actualTotalPhrases = Logica.totalPhrases(ejemplo);
		Assert.assertEquals(4, actualTotalPhrases, 0d);
	}
	
	@Test
    public void testTotalParagraphs() {
		String ejemplo = "Esto es. </p> Un texto de ejemplo. </p> Para el caso test. De contar palabras. </p> ";
		Integer actualTotalParagraphs = Logica.totalParagraphs(ejemplo);
		Assert.assertEquals(3, actualTotalParagraphs, 0d);
	}
	
	@Test
    public void testRemovePHtmlNotations() {
		String original = "Esto es. Un texto de ejemplo. Para el caso test. De contar palabras. ";
		String raw = "Esto es. </p> Un texto de ejemplo. </p> Para el caso test. De contar palabras. </p> ";
		String actualRemovedPHtmlNotations = Logica.removePHtmlNotations(raw);
		Assert.assertEquals(original, actualRemovedPHtmlNotations);
	}
	
	@Test
    public void testTotalPalindroms() {
		String ejemplo = "Lorem ipsum dolor sit amet, non consectetur adipiscing elit. Etiam sed velit a ante non parap.";
		Integer actualTotalPalindroms = Logica.totalPalindroms(ejemplo);
		Assert.assertEquals(3, actualTotalPalindroms, 0d);
	}
}
