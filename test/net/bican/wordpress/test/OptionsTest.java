package net.bican.wordpress.test;

import static org.junit.Assert.*;

import java.util.List;

import net.bican.wordpress.Option;

import org.junit.Test;

@SuppressWarnings({ "static-method", "javadoc" })
public class OptionsTest extends AbstractWordpressTest {
  
  private static final String DEFAULT_SITE_TITLE = "WordpressJavaTest"; //$NON-NLS-1$
  private static final String TEST_SITE_TITLE = "test site title"; //$NON-NLS-1$
  private static final String DEFAULT_TAGLINE = "Just another WordPress site"; //$NON-NLS-1$
  private static final String TEST_SITE = "test site"; //$NON-NLS-1$
  private static final String BLOG_TITLE = "blog_title"; //$NON-NLS-1$
  private static final String SITE_TAGLINE = "Site Tagline"; //$NON-NLS-1$
  private static final String BLOG_TAGLINE = "blog_tagline"; //$NON-NLS-1$
  
  @Test
  public void testGetOptions() {
    List<Option> options = WP.getOptions();
    assertNotNull(options);
    assertEquals(27, options.size()); // This is epic, I chose 27 before
                                      // counting. Marking the day I am lucky in
                                      // the most useless sense: 2015/06/28
  }
  
  @Test
  public void testGetOption() {
    Option option = WP.getOption(BLOG_TAGLINE);
    assertNotNull(option);
    assertEquals(BLOG_TAGLINE, option.getName());
    assertEquals(SITE_TAGLINE, option.getDesc());
  }
  
  @Test
  public void testGetOptionMore() {
    List<Option> options = WP.getOptions(BLOG_TAGLINE, BLOG_TITLE);
    assertNotNull(options);
    assertEquals(2, options.size());
  }
  
  @Test
  public void testSetOption() {
    Option option = new Option();
    option.setName(BLOG_TAGLINE);
    option.setValue(TEST_SITE);
    Option r = WP.setOption(option);
    assertNotNull(r);
    assertEquals(TEST_SITE, r.getValue());
    assertEquals(BLOG_TAGLINE, r.getName());
    option.setValue(DEFAULT_TAGLINE);
    WP.setOption(option);
  }
  
  @Test
  public void testSetOptions() {
    Option option1 = new Option();
    option1.setName(BLOG_TAGLINE);
    option1.setValue(TEST_SITE);
    Option option2 = new Option();
    option2.setName(BLOG_TITLE);
    option2.setValue(TEST_SITE_TITLE);
    List<Option> r = WP.setOptions(option1, option2);
    assertNotNull(r);
    assertEquals(2, r.size());
    Option r1 = r.get(0);
    assertNotNull(r1);
    assertEquals(BLOG_TAGLINE, r1.getName());
    assertEquals(TEST_SITE, r1.getValue());
    Option r2 = r.get(1);
    assertNotNull(r2);
    assertEquals(BLOG_TITLE, r2.getName());
    assertEquals(TEST_SITE_TITLE, r2.getValue());
    option1.setValue(DEFAULT_TAGLINE);
    option2.setValue(DEFAULT_SITE_TITLE);
  }
}
