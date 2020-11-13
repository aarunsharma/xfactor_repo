package com.xfactor.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.xfactor.features.BaseFeatures;
import com.xfactor.features.MyXfactorHomeFeatures;
import com.xfactor.generics.BaseTest;

public class MyXfactorHomeTest extends BaseTest
{
	@Test(priority=1)
	public void displayXfactorHomePage()
	{
		BaseFeatures bf = new BaseFeatures(driver);
		bf.clickOnMyXfactorHome();
		MyXfactorHomeFeatures mxhf = new MyXfactorHomeFeatures(driver);
		mxhf.verifyMyXfactorHomePage();
	}
	@Test(priority=2)
	public void searchingAllOpportunitiesBySource() throws IOException, InterruptedException
	{
		MyXfactorHomeFeatures mxhf = new MyXfactorHomeFeatures(driver);
		mxhf.searchBySource("All", fu.getPropertiesFileData("testdata/search_data.properties", "source_both"));
	}
	@Test(priority=3)
	public void searchingAllActiveOpportunitiesBySource() throws IOException, InterruptedException
	{
		MyXfactorHomeFeatures mxhf = new MyXfactorHomeFeatures(driver);
		mxhf.searchBySource("Active", fu.getPropertiesFileData("testdata/search_data.properties", "source_active"));
	}
	@Test(priority=4)
	public void searchingAllHistoricOpportunitiesBySource() throws IOException, InterruptedException
	{
		MyXfactorHomeFeatures mxhf = new MyXfactorHomeFeatures(driver);
		mxhf.searchBySource("Historic", fu.getPropertiesFileData("testdata/search_data.properties", "source_inactive"));
	}
	@Test(priority=5)
	public void searchingAllOpportunitiesByCategory() throws IOException, InterruptedException
	{
		MyXfactorHomeFeatures mxhf = new MyXfactorHomeFeatures(driver);
		mxhf.searchByCategory("All", fu.getPropertiesFileData("testdata/search_data.properties", "category_both"));
	}
	@Test(priority=6)
	public void searchingAllActiveOpportunitiesByCategory() throws IOException, InterruptedException
	{
		MyXfactorHomeFeatures mxhf = new MyXfactorHomeFeatures(driver);
		mxhf.searchByCategory("Active", fu.getPropertiesFileData("testdata/search_data.properties", "category_active"));
	}
	@Test(priority=7)
	public void searchingAllHistoricOpportunitiesByCategory() throws IOException, InterruptedException
	{
		MyXfactorHomeFeatures mxhf = new MyXfactorHomeFeatures(driver);
		mxhf.searchByCategory("Historic", fu.getPropertiesFileData("testdata/search_data.properties", "category_inactive"));
	}
}
