package com.gery.statsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class DefinitionsActivity extends Activity
{

	private ListView listView;
	ArrayAdapter<String> adapter;
	String [] definitions = {"Linear regression","Poisson regression","Cox regression","1-sample t-test","Wilcoxon sign rank (for one sample)","Wilcoxon sign rank (for paired measurements)","Paired-samples t-test","2-samples t-test",
			"Mann-Whitney U/2-samples Wilcoxon test)","ANOVA","Kruskal Wallis ANOVA","B-A Limits of agreement","ICC","Kappa","Weighted Kappa","Chi squared (x2) for trend","Chi squared (x2)","McNemar’s","Fisher’s exact","Binary logistic regression ","Ordinal logistic regression","Multinomial logistic regression"};
	
	
	String [] data = {"<b>Definition:</b><br/>" +
						"Linear regression analysis is used to assess the association between one or more predictor variables and a single continuous numeric outcome. " +
						"<br/><br/><b>Example:</b> <br/>" +
						"A study was conducted to look at adult height and whether or not maternal height, paternal height, gestational age, and socioeconomic status are associated with adult height. Age, sex and life-long disease/disorder status are also entered into the model to control for their influence.If the model is good, we can predict the adult heights of children according to their individual pattern of predictor variables." +
						"<br/><br/><b>Data Checks:</b><br/>" +
						"Outcome variable must be numeric. Residuals should be normally distributed. Outliers/influential values should be examined. Model fit statistics should be examined and compared between different models if relevant. Larger samples are needed to look for interactions between predictor variables" +
						"<br/><br/><b>Data summaries:</b><br/>" +
						"Residuals (residual values are saved during main regression analysis). " +
						"Model fit statistics/indexes" +
						"<br/><br/><b>Graphical display:</b><br/>" +
						"Various plots are available to check normal distribution of residual statistics (these options can be selected during main regression analysis)",
						
						" <b>Definition:</b><br/>" +
								"Poisson regression analysis is used to assess the association between one or more predictor variables and a single numeric frequency outcome. " +
						"<br/><br/><b>Example:</b> <br/>" +
								"A study was undertaken to look at the variables associated with number of children raised per family. Fertility level, maternal year of birth, maternal and paternal number of siblings, maternal age at first pregnancy, and presence of complications at first birth were used as main predictors; socioeconomic status, marital status were also entered into the model as covariates to control for their influence." +
						"<br/><br/><b>Data Checks:</b><br/>" +
								"Outcome variable must be numeric frequency"+
								"<br/><br/>Residuals should be normally distributed"+
								"<br/><br/>Outliers/influential values should be examined"+
								"<br/><br/>Model fit statistics should be examined and compared between different models if relevant"+
								"<br/><br/>Larger samples are needed to look for interactions between predictor variables" +
						"<br/><br/><b>Data summaries:</b><br/>" +
								"Residuals (residual values are saved during main regression analysis)" +
								"Model fit statistics/indexes" +
						"<br/><br/><b>Graphical display:</b><br/>" +
								"Various plots are available to check normal distribution of residual statistics (these options can be selected during main regression analysis)",
								
						" <b>Definition:</b> <br/>" +
										"Cox regression analysis (aka cox proportional hazards regression, time-to-event, or survival analysis) is used to assess the association between one or more predictor variables and a single time-to-event outcome. " +
										"<br/><br/>The key to time-to-event/survival analysis is that people/cases in the sample are followed for different lengths of time, and at the end of the study or at the time each person leaves the study (whichever occurs first) the individual/case may or may not have experienced the ‘event’ of interest. Individuals who do not experience the event before exiting the study are known as censored observations." +
						"<br/><br/><b>Example:</b> <br/>" +
										"A study was conducted to examine first tooth loss in relation to the age of the child, gender, and ethnicity. Tooth loss was the ‘event’ of interest. Children aged five years were recruited during a two year period and were followed for between one month and two years. At the end of the study 65% of the children had lost their first tooth and the remaining 35% had not by the time they exited the study." +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"Outcome variable must be time to an event or to leaving the study, some events must be unobserved." +
										"<br/><br/>Residuals should be normally distributed" +
										"<br/><br/>Outliers/influential values should be examined" +
										"<br/><br/>Model fit statistics should be examined and compared between different models if relevant" +
										"<br/><br/>Larger samples are needed to look for interactions between predictor variables" +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Residuals (residual values are saved during main regression analysis)" +
										"<br/><br/>Model fit statistics/indexes" +
						"<br/><br/><b>Graphical display:</b><br/>" +
										"Various plots are available to check normal distribution of residual statistics (these options can be selected during main regression analysis)" +
										"<br/><br/>Life tables" +
										"<br/><br/>Kaplan Meier plots",
									
						" <b>Definition:</b> <br/>" +
										"The 1-sample t-test is used when you have a single sample of data and you want to see if it is significantly different from a particular value (referred to as the hypothesised mean or value – usually derived from literature, professional practice, or expert opinion)" +
										"<br/><br/>The important feature of the 1-sample t-test is that data is only available from one group (the total study sample).The comparison value/hypothesised median is a single number taken from a reliable source such as past literature, research, or clinical/scientific knowledge." +
						"<br/><br/><b>Example:</b> <br/>" +
										"A study was conducted to see if the mean (average) age of first pregnancy in a current sample was significantly different from the known average in 1990?" +
										"<br/><br/>A study was conducted to assess whether the heights of a current sample of British adults with cerebral palsy differ significantly from the known average height in Britain?" +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"Normal distribution of the outcome variable " +
										"<br/><br/>Sample size at least 20" +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Mean " +
										"<br/><br/>Standard Deviation" +
						"<br/><br/><b>Graphical display:</b><br/>" +
										"A Histogram or simple dot plot can be used to show the distribution of the outcome variable. " +
										"<br/><br/>Sample estimates (mean and standard deviation) can be added to the displays to give additional information.",
												
						" <b>Definition:</b> <br/>" +
										"The Wilcoxon test is used when you want to compare the summary score of a numeric outcome for a whole sample against a particular hypothesised value; but, the outcome data do not meet parametric data assumptions. The Wilcoxon test is a nonparametric alternative to the 1-sample t-test, so examines the sample and hypothesised medians rather than means." +
						"<br/><br/><b>Example:</b> <br/>" +
										"A study was undertaken to compare median heart rate in a sample of 10 obese adults aged 30-35 years to the known median heart rate for normal weight adults of the same age reported in a medical journal." +
										"<br/><br/>In a different study heart rate was measured in 10 obese patients before and after an exercise intervention to see if exercise resulted in a significant increase in heart rate. " +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"No assumptions are made about the data – data can be skew or normal and smaller sample sizes can be analysed." +
										"<br/><br/>Although there are no specific cut-offs for sample size, if you have samples of fewer than 5 people/cases, you should consider presenting the data in graphical displays and describing differences rather than trying to make statistical comparisons." +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Median" +
										"<br/><br/>Interquartile range" +
						"<br/><br/><b>Graphical display:</b><br/>" +
										"For a single sample, a Histogram or dot plot can be used to show the distribution of the outcome variable." +
										"<br/><br/>Sample estimates (median and interquartile range) can be added to the displays to give additional information.",
														
						" <b>Definition:</b> <br/>" +
										"The Wilcoxon sign rank test is used when you have two paired groups or two repeated measurements and you want to examine the within-pair differences in a numeric outcome variable to look for a significant difference/change from zero; but, the data do not meet parametric data assumptions. The Wilcoxon test is a nonparametric alternative to the paired-samples t-test, so uses medians rather than means. " +
						"<br/><br/><b>Example:</b> <br/>" +
										"In a further study, 10 overweight and 10 normal weight adults were one-to-one matched for height, age, sex, and socioeconomic status, and had their heart rates measured and compared within pairs to see if there was a significant difference in heart rate associated with weight status." +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"No assumptions are made about the data – data can be skew or normal and smaller sample sizes can be analysed." +
										"<br/><br/>Although there are no specific cut-offs for sample size, if you have samples of fewer than 5 people/cases, you should consider presenting the data in graphical displays and describing differences rather than trying to make statistical comparisons." +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Median" +
										"<br/><br/>Interquartile range" +
						"<br/><br/><b>Graphical display:</b><br/>" +
										"For paired data a scatter plot (one measurement from the pair on each axis) or a line diagram should be used to show the pairing in the data." +
										"<br/><br/>Sample estimates (median and interquartile range) can be added to the displays to give additional information.",
																
						" <b>Definition:</b> <br/>" +
										"The paired-samples t-test is used when you have two paired groups or repeated measurements and you want to compare their mean (average) scores on a numeric outcome variable to look for a significant difference/change" +
										"<br/><br/>Paired measurements can be taken from two separate but one-to-one matched groups/samples, or can come from repeated measurements from a single group/sample." +
						"<br/><br/><b>Example:</b> <br/>" +
										"Mathed Groups:" +
										"<br/><br/>In a study 40 children from a comprehensive school and 40 children from a private school were individually matched for disability, age, sex, parental marital status, and number of siblings. Grade-point average (GPA) was recorded and compared within pairs to see if there was a significant difference in average GPA between school types." +
										"<br/><br/>Repeated Measurements:" +
										"<br/><br/>A study was conducted to compare lung function in sample of 50 young adults before and after a 30 minute exercise intervention." +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"Normal distribution of the outcome variable (differences between groups/measurements)" +
										"<br/><br/>Sample size (number of pairs of measurements) at least 20" +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Mean within-pair difference" +
										"<br/><br/>Standard deviation of within-pair differences" +
						"<br/><br/><b>Graphical display:</b><br/>" +
										"For paired data a scatter plot (one measurement from the pair on each axis) or a line diagram should be used to show the pairing in the data." +
										"<br/><br/>Sample estimates (means and standard deviations) can be added to the displays to give additional information.",
																		
						" <b>Definition:</b> <br/>" +
										"The 2-samples t-test is used when you have two independent groups and you want to compare their mean (average) scores on a numeric outcome variable to look for a significant difference." +
						"<br/><br/><b>Example:</b> <br/>" +
										"A study was conducted to look at the association between game console ownership and weight status in 100 children. 47 children who owned a computer games console and 53 children who do not had their BMIs measured, and the mean BMIs in each group were compared to see if BMI differed significantly between the groups." +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"Normal distribution of the outcome variable in each group." +
										"<br/><br/>Approximately equal variability of the outcome in each group" +
										"<br/><br/>Sample size at least 20 per group" +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Mean" +
										"<br/><br/>Standard deviation" +
						"<br/><br/><b>Graphical display:</b><br/>" +
										"A dot diagram is the best way to present the data for two separate groups, to show distribution of data points and comparison between groups." +
										"<br/><br/>Sample estimates (means and standard deviations) can be added to the displays to give additional information",
																				
						" <b>Definition:</b> <br/>" +
										"The Mann-Whitney U test is used when you have two independent groups and you want to compare their summary scores on a numeric outcome variable to look for a significant difference; but, the outcome variable data do not meet parametric data assumptions." +
										"<br/><br/>The Mann-Whitney U test is a nonparametric alternative to the 2-samples t-test; it compares ranked values between groups (rather than the raw data values) and hence does not make distributional assumptions." +
						"<br/><br/><b>Example:</b> <br/>" +
										"A study was conducted on 20 children to compare BMI between 13 children that own a computer games console and 7 children that do not, to see if BMI differs significantly between the groups." +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"No assumptions are made about the data – data can be skewed and smaller sample sizes can be analysed." +
										"<br/><br/>Although there are no specific cut-offs for sample size, with samples of fewer than 5 people/cases per group, you should consider presenting the data in graphical displays and describing differences rather than trying to make statistical comparisons." +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Median" +
										"<br/><br/>Interquartile range" +
						"<br/><br/><b>Graphical display:</b><br/>" +
										"A dot diagram is the best way to present the data for two separate groups, to show distribution of data points and comparison between groups." +
										"<br/><br/>Sample estimates (medians and interquartile ranges) can be added to the displays to give additional information.",
																						
						" <b>Definition:</b> <br/>" +
										"ANOVA (Analysis of Variance) is used when you have three or more independent groups and you want to compare their mean (average) scores on a numeric outcome variable, to look for a significant difference among groups." +
										"<br/><br/>ANOVA differentiates between grouping variables (e.g., Gender) and levels/groups within the grouping variable (e.g., males and females)." +
										"<br/><br/>The simplest ANOVA is a one-way ANOVA, which is used to compare three or more groups/levels of one grouping variable for a single numeric outcome; one-way ANOVA is an extension of the 2-samples t-test, which compares only two levels/groups." +
										"<br/><br/>ANOVA can be extended to examine multiple grouping variables; each with 2 or more levels, and to examine interactions between these grouping variables, in a single analyses (Factorial ANOVA). " +
										"<br/><br/>If relevant ANOVA can also be used to compare between grouping variables and levels for more than one numeric outcome variable (MANOVA)." +
						"<br/><br/><b>Example:</b> <br/>" +
										"One-way ANOVA:" +
										"<br/><br/>A study is conducted to compare alcohol tolerance in five different nationalities. 300 participants from England (n=67), Japan (n=57), Australia (n=66), Mexico (n=59), and Pakistan (n=51) were given two units of alcohol; after an hour blood alcohol level was measured. Average remaining alcohol was compared between the five groups to see if group differed significantly." +
										"<br/><br/>Extension to Factorial ANOVA:" +
										"The above study extended their analysis to also look at differences in alcohol tolerance between males and females within and between the five nations." +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"Normal distribution of the outcome variable in each group." +
										"<br/><br/>Approximately equal variability of the outcome in each group" +
										"<br/><br/>Sample size at least 20 per group (larger samples are needed to look for interactions between grouping variables)" +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Mean" +
										"<br/><br/>Standard deviation" +
						"<br/><br/><b>Graphical display:</b><br/>" +
										"A dot diagram is the best way to present the data for separate groups, to show distribution of data points and comparison between groups." +
										"<br/><br/>Sample estimates (means and standard deviations) can be added to the displays to give additional information.",
							
						" <b>Definition:</b> <br/>" +
										"Kruskal Wallis ANOVA (Analysis of Variance) is used when you have three or more independent groups and you want to compare their summary scores on a single numeric outcome variable to look for a significant difference; but, the outcome data do not meet parametric data assumptions." +
										"<br/><br/>The Kruskal Wallis test is the nonparametric alternative to the one-way ANOVA" +
						"<br/><br/><b>Example:</b> <br/>" +
										"A study is conducted to compare alcohol tolerance in five different nationalities. 35 participants from England (n=8), Japan (n=6), Australia (n=7), Mexico (n=6), and Pakistan (n=8) were given two units of alcohol; after an hour blood alcohol level was measured. Average remaining alcohol was compared between the five groups to see if group differed significantly." +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"No assumptions are made about the data – data can be skewed and smaller sample sizes can be analysed." +
										"<br/><br/>Although there are no specific cut-offs for sample size, with samples of fewer than 5 people/cases per group, you should consider presenting the data in graphical displays and describing differences rather than trying to make statistical comparisons." +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Median" +
										"<br/><br/>Interquartile range" +
						"<br/><br/><b>Graphical display:</b><br/>" +
										"A dot diagram is the best way to present the data for two separate groups, to show distribution of data points and comparison between groups." +
										"<br/><br/>Sample estimates (medians and interquartile ranges) can be added to the displays to give additional information.",

						" <b>Definition:</b> <br/>" +
										"Bland-Altman Limits of Agreement (BALOA) are used to check the reliability (agreement/repeatability) of two paired numeric measurements of the same thing. The two measurements may be taken by the same person with an interval in between (test-retest), or may be taken by two separate people (inter-rater)." +
										"<br/><br/>BALOA use descriptive statistics but the method does not involve a statistical significance test." +
						"<br/><br/><b>Example:</b> <br/>" +
										"A study was conducted to assess agreement between a new tool for measuring blood pressure and an existing standard tool. 150 patients attending GP clinics had their blood pressure measured with the two tools and the paired results were compared." +
										"<br/><br/>A study wanted to assess the inter-rater reliability of a measure of depression. Two different clinical raters assessed a group of 100 patients using the same tool, and each pair of results was compared." +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"Normal distribution of the differences between the two measurements" +
										"<br/><br/>Approximately equal variability across the range of measurements" +
										"<br/><br/>Sample size at least 20 per group " +
										"<br/><br/>Pairing must be kept in the graphical display and analysis of data when assessing agreement" +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Mean within-pair difference" +
										"<br/><br/>Standard deviation of within-pair differences" +
						"<br/><br/><b>Graphical display:</b><br/>" +
										"Bland-Altman plot for limits of agreement (based on a scatter plot of the differences between the measurements against the average of the measurements)",
																												
						" <b>Definition:</b> <br/>" +
										"Intraclass Correlation (ICC) is used to assess the reliability/agreement (similarity of scoring) between/among repeated numeric measurements of the same thing. The multiple measurements may be taken by the same person/rater (test-retest), or may be taken by several separate people/raters at the same time (inter-rater)." +
										"<br/><br/>Different types of ICC (1, 2, and 3) are used depending on the specific study design and whether an average is taken across raters (k) or not." +
						"<br/><br/><b>Example:</b> <br/>" +
										"A study was used to assess the reliability of a new pedometer. 35 participants were asked to walk wearing the pedometer while the experimenter counted 50 steps. This was repeated five times and the five pedometer readings were compared for each person." +
										"<br/><br/>A study was conducted to test agreement among clinical raters when assessing hearing deficits in children. 46 children had their hearing assessed by four independent clinical raters, and the four hearing scores were compared for each child" +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"Normal distribution in the numeric outcome for each rater." +
										"<br/><br/>Sample size at least 20 cases" +
										"<br/><br/>Main ICC types for different study designs:" +
										"<br/><br/>	1) A random set of raters is used to assess a random sample of individuals/cases; a different set of raters may assess each case." +
										"<br/><br/>	2) A random set of raters is used to assess a random sample of individuals/cases; all cases are rated by the same raters." +
										"<br/><br/>	3) A fixed set of raters is used to assess a random sample of individuals/cases" +
										"<br/><br/>Pairing must be kept in the graphical display and analysis of data when assessing agreement" +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"" +
						"<br/><br/><b>Graphical display:</b><br/>" +
										"An ICC plot can be constructed using a dot plot; participants on the x axis, scores on the y axis, and different points/dots on the plot for each rater.",
																														
						" <b>Definition:</b> <br/>" +
										"The Kappa test is used to assess agreement between two binary categorical measurements of the same thing. Measurements may be taken by one rater using two different measuring tools, one tool at two time-points, or by two raters using the same measuring tool. " +
										"<br/><br/>Kappa makes an adjustment to the percentage total agreement between two raters to account for a proportion of chance agreement." +
						"<br/><br/><b>Example:</b> <br/>" +
										"During a tool development study, two psychiatrists used a new diagnostic tool for schizophrenia to assess 121 patients attending a mental health clinic. Both clinicians identified each patient as either having or not having schizophrenia. The agreement between the clinicians for each case was then assessed." +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"Kappa should be used for binary categorical outcomes" +
										"<br/><br/>Pairing must be kept in the graphical display and analysis of data when assessing agreement" +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Frequencies"+
										"Percentages" +
						"<br/><br/><b>Graphical display:</b><br/>" +
										"2x2 contingency table; measurement 1 as rows and measurement 2 as columns",
																																
						" <b>Definition:</b> <br/>" +
										"The Weighted Kappa test is used to assess agreement between two paired ordinal categorical measurements of the same thing. The measurements may be taken by one rater using two different measuring tools, or one tool at two time-points, or by two raters using the same measuring tool. " +
										"<br/><br/>Weighted kappa takes account of the degree of disagreement in measurements between raters using weightings rather than treating all differences as complete disagreement. For example ratings of 1 and 3 by two raters show greater disagreement than ratings of 1 and 2." +
										"<br/><br/>Kappa makes an adjustment to the percentage total agreement between two raters to account for a proportion of chance agreement." +
						"<br/><br/><b>Example:</b> <br/>" +
										"A study was conducted to look at the consistency of mental health evaluation in GP surgeries, using a standardised measuring tool for depression. Two GPs each administered the depression tool, which yields four response categories (none, mild, moderate, and severe), to 79 adult patients. Agreement and similarity of scoring between the two GPs was then assessed." +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"Weighted Kappa should be used for ordinal categorical outcomes" +
										"<br/><br/>Pairing must be kept in the graphical display and analysis of data when assessing agreement" +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Frequencies"+
										"Weights"+
										"Percentages"+
						"<br/><br/><b>Graphical display:</b><br/>" +
										"k x k contingency table; ordinal measurement 1 as rows and ordinal measurement 2 as columns",
							
						" <b>Definition:</b> <br/>" +
										"The Chi squared for trend test is used to look at the difference/association between a binary categorical (grouping) variable and a categorical variable with three or more ordered/ordinal outcome options within a contingency table." +
										"<br/><br/>Chi squared works by comparing the distribution of sample data in the cells of a contingency table to a table of ‘expected values’ based on chance alone." +
						"<br/><br/><b>Example:</b> <br/>" +
										"A study was conducted to see if there was an association between smoking statuses (yes/no) and self-rated life satisfaction (low, medium, or high). 100 people were asked to say whether or not they currently smoked and to rate their life satisfaction as low, medium or high. The responses were then entered into a 2x3 contingency table for analysis." +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"Sample size of at least 20 in cells of the expected values contingency table" +
										"<br/><br/>There should be not extreme proportions: i.e., the proportions in each of the cells of the contingency table should lie between 0.1 and 0.9 (10 and 90%)." +
										"<br/><br/>Response options for the ordinal outcome variable should be presented in order in the contingency table." +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Frequencies" +
										"<br/><br/>Percentages/proportions" +
						"<br/><br/><b>Graphical display:</b><br/>" +
										"k x 2 contingency table; ordinal outcome variable as rows and grouping variable as columns",
																	
						" <b>Definition:</b> <br/>" +
										"The Chi squared test is most often used to look at the difference/association between two binary categorical variables in a 2x2 contingency table. " +
										"<br/><br/>Chi squared can also be extended to larger contingency tables that compare two categorical variables with more than two nominal outcome options." +
										"<br/><br/>Chi squared works by comparing the distribution of observed data in a contingency table to a table of ‘expected values’ based only on chance." +
						"<br/><br/><b>Example:</b> <br/>" +
										"A study was conducted to see if there was an association between smoking status (yes/no) and sex (male/female). 100 people were asked their sex and whether or not they currently smoked. Responses were entered into a 2x2 contingency table for analysis." +
										"<br/><br/>Another study was conducted to assess the association between smoking status and working status (unemployed, part-time, full-time, self-employed, or student). 300 people reported their smoking and employment statuses and responses were entered into a 2x5 contingency table for analysis." +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"Sample size of at least 20 in cells of the expected values contingency table." +
										"<br/><br/>There should be not extreme proportions: i.e., the proportions in each of the cells of the contingency table should lie between 0.1 and 0.9 (10 and 90%)." +
										"<br/><br/>Responses for outcome variables with 3+ options should be unordered (nominal)." +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Frequencies" +
										"<br/><br/>Percentages/proportions" +
						"<br/><br/><b>Graphical display:</b><br/>" +
										"2 x 2 contingency table (or k x k table if extending chi squared); exposure/group variable as rows and outcome variable as columns",
																																						
						" <b>Definition:</b> <br/>" +
										"McNemar’s test is used to look at the difference/association between two paired binary categorical variables in a 2x2 table. " +
										"<br/><br/>Pairing in the data should be presented in the contingency table; the four table cells represent the four possible outcomes from the two measurements (e.g., positive-positive, negative-negative, positive-negative, or negative-positive).<br/><br/>McNemar test assesses how much the ‘disagreeing’ cells deviate from chance disagreement." +
						"<br/><br/><b>Example:</b> <br/>" +
										"A study was conducted to assess the difference in nickel allergy-related rash presentation before and after treatment with a new antihistamine drug. Individuals with a nickel allergy were exposed to nickel and the presence/absence of a skin rash was recorded. Then all participants were given the new drug and one hour later the presence/absence of rash was again recorded. The paired information was presented in a 2x2 table " +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"Sample size of at least 20 in cells of the expected values 2x2 contingency table. <br/><br/>Pairing must be kept in the graphical display and analysis of data when using McNemar’s test" +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Frequencies" +
										"<br/><br/>Percentages/proportions" +
						"<br/><br/><b>Graphical display:</b><br/>" +
										"2x2 contingency table; measurement 1 as rows and measurement 2 as columns with four cells representing the four possible paired outcomes",
																																								
						" <b>Definition:</b> <br/>" +
										"The Fisher’s exact test is used to look at the difference/association between two binary categorical variables in a 2x2 table. Fisher’s exact is used when categorical data assumptions are not met for the traditional chi squared test; if there are extreme proportions (below 10% or above 90%) or small sample sizes in any of the table cells." +
										"<br/><br/>Fisher’s exact test works by taking the table marginals (the row and column totals) and finding the number of more extreme distributions for values in the table cells than the distribution/split in the observed data." +
						"<br/><br/><b>Example:</b> <br/>" +
										"A study was conducted to assess the association between the presence of a rare childhood disease and exposure to both chickenpox and measles within a 12 month period. 367 Parents were asked to report if their child had the rare disease (yes/no) and if their child had been exposed to both chickenpox and measles in the same year (yes/no). The results were presented in a 2x2 contingency table for analysis; only small numbers of children fell into either of the yes categories with only 2% of the sample reporting yes for both. " +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"No assumptions are made about the data – table proportions can be extreme and smaller sample sizes can be analysed." +
										"<br/><br/>Although there are no specific cut-offs for sample size, with samples of fewer than 5 people/cases, you should consider describing differences observed in the 2x2 table rather than trying to make statistical comparisons." +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Frequencies" +
										"<br/><br/>Percentages/proportions" +
						"<br/><br/><b>Graphical display:</b><br/>" +
										"2 x 2 contingency table; exposure/group variable as rows and outcome variable as columns",
							
						" <b>Definition:</b> <br/>" +
										"Binary logistic regression analysis is used to assess the association between one or more predictor variables and a single binary categorical outcome." +
						"<br/><br/><b>Example:</b> <br/>" +
										"A study was conducted to look at the associations of a number of predictors to smoking status. Weight, age, maternal and paternal smoking status, socioeconomic status and number of children were all used as predictors of smoking as a yes/no outcome." +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"The outcome should be a binary/dichotomous variable" +
										"<br/><br/>Residuals should be normally distributed" +
										"<br/><br/>Outliers/influential values should be examined" +
										"<br/><br/>Model fit statistics should be examined and compared between different models if relevant" +
										"<br/><br/>Larger samples are needed to look for interactions between predictor variables" +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Residuals (residual values are saved during main regression analysis)" +
										"<br/><br/>Model fit statistics/indexes",
										
						" <b>Definition:</b> <br/>" +
										"Ordinal logistic regression analysis is used to assess the association between one or more predictor variables and a single ordinal categorical outcome. " +
						"<br/><br/><b>Example:</b> <br/>" +
										"A study was conducted to look at the associations of a number of predictor variables to adult weight status categorised as underweight, normal weight, overweight, or obese. Age, maternal and paternal BMI, socioeconomic status, and number of children were all used to model/predict weight status." +
						"<br/><br/><b>Data Checks:</b><br/>" +
										"The outcome should be an ordinal (ordered) categorical variable" +
										"<br/><br/>Residuals should be normally distributed" +
										"<br/><br/>Outliers/influential values should be examined" +
										"<br/><br/>Model fit statistics should be examined and compared between different models if relevant" +
										"<br/><br/>Larger samples are needed to look for interactions between predictor variables" +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Residuals (residual values are saved during main regression analysis" +
										"<br/><br/>Model fit statistics/indexes",
																																														
						"<b>Definition:</b><br/>" +
										"Multinomial logistic regression analysis is used to assess the association between one or more predictor variables and a single nominal categorical outcome. " +
						"<br/><br/><b>Example:</b> <br/>" +
										"A study was conducted to look at the associations of a number of predictor variables to an individual’s majority mode of transport to work (walk, bike, car, bus, or train). Age, socioeconomic status, number of dependents living at home, distance to workplace, and availability of a car were all used to model/predict choice of transport to work." +
						"<br/><br/><b><b>Data Checks:</b></b><br/>" +
										"The outcome should be a nominal (unordered) categorical variable" +
										"<br/><br/>Residuals should be normally distributed" +
										"<br/><br/>Outliers/influential values should be examined" +
										"<br/><br/>Model fit statistics should be examined and compared between different models if relevant" +
										"<br/><br/>Larger samples are needed to look for interactions between predictor variables" +
						"<br/><br/><b>Data summaries:</b><br/>" +
										"Residuals (residual values are saved during main regression analysis)" +
										"<br/><br/>Model fit statistics/indexes"

					};
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.definitions);
	    
	    ImageView backButton = (ImageView)findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener()
        {
        	@Override
        	public void onClick(View view)
        	{
        		finish();
        	}
        });
	    
	    listView = (ListView)findViewById(R.id.listView1);
	    listView.setOnItemClickListener(onClick);
	    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, definitions);
	    listView.setAdapter(adapter);
	}
	
	ListView.OnItemClickListener onClick = new ListView.OnItemClickListener() 
	{
		  @Override
		  public void onItemClick(AdapterView<?> list, View view, int item, long id)
		  {
			  Intent intent = new Intent(DefinitionsActivity.this, InformationActivity.class);
		      intent.putExtra("Explanation", data[item]);
		      intent.putExtra("Title", definitions[item]);
		      startActivity(intent);
		  }
	};    
	
}
