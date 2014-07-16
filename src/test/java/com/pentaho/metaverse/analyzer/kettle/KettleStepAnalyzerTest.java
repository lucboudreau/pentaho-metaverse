/*!
 * PENTAHO CORPORATION PROPRIETARY AND CONFIDENTIAL
 *
 * Copyright 2002 - 2014 Pentaho Corporation (Pentaho). All rights reserved.
 *
 * NOTICE: All information including source code contained herein is, and
 * remains the sole property of Pentaho and its licensors. The intellectual
 * and technical concepts contained herein are proprietary and confidential
 * to, and are trade secrets of Pentaho and may be covered by U.S. and foreign
 * patents, or patents in process, and are protected by trade secret and
 * copyright laws. The receipt or possession of this source code and/or related
 * information does not convey or imply any rights to reproduce, disclose or
 * distribute its contents, or to manufacture, use, or sell anything that it
 * may describe, in whole or in part. Any reproduction, modification, distribution,
 * or public display of this information without the express written authorization
 * from Pentaho is strictly prohibited and in violation of applicable laws and
 * international treaties. Access to the source code contained herein is strictly
 * prohibited to anyone except those individuals and entities who have executed
 * confidentiality and non-disclosure agreements or other agreements with Pentaho,
 * explicitly covering such access.
 */

package com.pentaho.metaverse.analyzer.kettle;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.pentaho.di.trans.step.StepMeta;
import org.pentaho.platform.api.metaverse.IMetaverseBuilder;
import org.pentaho.platform.api.metaverse.IMetaverseObjectFactory;
import org.pentaho.platform.api.metaverse.MetaverseAnalyzerException;

import com.pentaho.metaverse.testutils.MetaverseTestUtils;

/**
 * @author mburgess
 * 
 */
@RunWith( MockitoJUnitRunner.class )
public class KettleStepAnalyzerTest {

  KettleStepAnalyzer kettleStepAnalyzer;

  @Mock
  private IMetaverseBuilder builder;

  private IMetaverseObjectFactory factory;

  @Mock
  private StepMeta mockStepMeta;

  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {

    factory = MetaverseTestUtils.getMetaverseObjectFactory();

    kettleStepAnalyzer = new KettleStepAnalyzer();
    kettleStepAnalyzer.setMetaverseBuilder( builder );
    kettleStepAnalyzer.setMetaverseObjectFactory( factory );
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testSetMetaverseBuilder() {
    assertNotNull( kettleStepAnalyzer.metaverseBuilder );
  }

  @Test
  public void testSetMetaverseObjectFactory() {
    assertNotNull( kettleStepAnalyzer.metaverseObjectFactory );
  }

  @Test( expected = MetaverseAnalyzerException.class )
  public void testNullAnalyze() throws MetaverseAnalyzerException {
    kettleStepAnalyzer.analyze( null );
  }

  @Test( expected = MetaverseAnalyzerException.class )
  public void testAnalyze() throws MetaverseAnalyzerException {
    kettleStepAnalyzer.analyze( new StepMeta() );
  }
}
