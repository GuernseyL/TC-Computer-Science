package Q1.Java.Langdocs;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class prog850b {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("langdat/prog850b.csv"));
        Map<String, Integer> map = new TreeMap<>();
        String junk = file.nextLine();
        while (file.hasNextLine()) {
            String line = file.nextLine();
            if (!line.substring(0,1).equals("\"")) {
                String[] split = line.split(",");
                if (!split[1].equals("total")) {
                    map.put(split[0], map.getOrDefault(split[0], 0) + Integer.parseInt(split[split.length - 1]));
                }
            }
            else {
                String line2 = line.substring(1);
                int Data = line2.indexOf("\"");
                String key = line.substring(0, Data+2);
                line = line.substring(Data+1);
                String[] data = line.split(",");
                if (!data[0].equals("total")) {
                    map.put(key, map.getOrDefault(key, 0) + Integer.parseInt(data[data.length-1]));
                }
            }
        }
        Set<String> keys = map.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            int value = map.get(key);
            System.out.println(key + ": " + value);
        }
    }
}
/*
"Action taken in response to recruitment difficulties: brought in contractors, or contracted work out": 19197
"Employees received training in trade related skills (eg plumbing, electrical, construction)": 35172
"Existing employees most need to improve trade related skills (eg plumbing, electrical, construction)": 22545
"Skills from job applicants: Trade related skills (eg plumbing, electrical, construction) - skills difficult to obtain": 29274
"Skills from job applicants: Trade related skills (eg plumbing, electrical, construction) - skills not difficult to obtain": 19311
"Skills from job applicants: Trade related skills (eg plumbing, electrical, construction) - skills not required": 55125
Action taken in response to recruitment difficulties: employed temporary workers: 8877
Action taken in response to recruitment difficulties: increased advertising / recruitment spend: 12915
Action taken in response to recruitment difficulties: increased hours worked by existing employees (eg overtime): 12222
Action taken in response to recruitment difficulties: increased training given to the existing workforce: 8742
Action taken in response to recruitment difficulties: increased wages or salaries: 10467
Action taken in response to recruitment difficulties: none of the above: 4344
Action taken in response to recruitment difficulties: recruited workers from overseas: 6822
Action taken in response to recruitment difficulties: trained less well-qualified recruits: 10254
Action taken in response to recruitment difficulties: used new recruitment methods or channels: 11289
Action taken in response to recruitment difficulties: worked with tertiary education sector to increase supply of skills needed: 2136
Business vacancies: No: 13512
Business vacancies: Yes: 42426
Difficulty filling vacancies: No: 17175
Difficulty filling vacancies: Yes: 25851
Employees received external training - not towards a New Zealand qualification - 1-25%: 15708
Employees received external training - not towards a New Zealand qualification - 26-50%: 7245
Employees received external training - not towards a New Zealand qualification - 51-75%: 3627
Employees received external training - not towards a New Zealand qualification - 76-100%: 5283
Employees received external training - not towards a New Zealand qualification - Zero: 5052
Employees received external training - not towards a New Zealand qualification - don't know: 1077
Employees received external training - towards a New Zealand qualification (eg a certificate or trade qualification) - 1-25%: 16764
Employees received external training - towards a New Zealand qualification (eg a certificate or trade qualification) - 26-50%: 4701
Employees received external training - towards a New Zealand qualification (eg a certificate or trade qualification) - 51-75%: 1902
Employees received external training - towards a New Zealand qualification (eg a certificate or trade qualification) - 76-100%: 1086
Employees received external training - towards a New Zealand qualification (eg a certificate or trade qualification) - Zero: 12246
Employees received external training - towards a New Zealand qualification (eg a certificate or trade qualification) - don't know: 1032
Employees received external training facilitated or funded by the business: No: 14517
Employees received external training facilitated or funded by the business: Yes: 35409
Employees received internal training - not towards a New Zealand qualification - 1-25%: 9948
Employees received internal training - not towards a New Zealand qualification - 26-50%: 8151
Employees received internal training - not towards a New Zealand qualification - 51-75%: 7317
Employees received internal training - not towards a New Zealand qualification - 76-100%: 14967
Employees received internal training - not towards a New Zealand qualification - Zero: 1824
Employees received internal training - not towards a New Zealand qualification - don't know: 1104
Employees received internal training - towards a New Zealand qualification (eg a certificate or trade qualification) - 1-25%: 12543
Employees received internal training - towards a New Zealand qualification (eg a certificate or trade qualification) - 26-50%: 3813
Employees received internal training - towards a New Zealand qualification (eg a certificate or trade qualification) - 51-75%: 1830
Employees received internal training - towards a New Zealand qualification (eg a certificate or trade qualification) - 76-100%: 1911
Employees received internal training - towards a New Zealand qualification (eg a certificate or trade qualification) - Zero: 21108
Employees received internal training - towards a New Zealand qualification (eg a certificate or trade qualification) - don't know: 2310
Employees received internal training: No: 7386
Employees received internal training: Yes: 42648
Employees received training in computer skills: 17421
Employees received training in customer service /  sales skills: 15534
Employees received training in health and safety training: 33057
Employees received training in management/supervisory skills: 13419
Employees received training in marketing skills: 6042
Employees received training in none of the above: 2889
Employees received training in numeracy skills (eg ability to use numbers and measures): 4266
Employees received training in oral communication skills: 7137
Employees received training in professional  / technical skills: 17886
Employees received training in team working skills: 13497
Employees received training in written communication skills: 5022
Existing employees most need to improve computer skills: 14352
Existing employees most need to improve customer service / sales skills: 19476
Existing employees most need to improve management / supervisory skills: 15873
Existing employees most need to improve marketing skills: 8775
Existing employees most need to improve none of the above: 11538
Existing employees most need to improve numeracy skills (eg ability to use numbers and measures): 8964
Existing employees most need to improve oral communication skills: 15204
Existing employees most need to improve professional / technical skills: 12246
Existing employees most need to improve team working skills: 18381
Existing employees most need to improve written communication skills: 13404
Expenditure on external training: 2074745171
Expenditure on internal training: -2114774782
External training providers used and effective: commercial training organisations - did not use: 11502
External training providers used and effective: commercial training organisations - effective: 26334
External training providers used and effective: commercial training organisations - not effective: 678
External training providers used and effective: other external providers - did not use: 19044
External training providers used and effective: other external providers - effective: 18990
External training providers used and effective: other external providers - not effective: 396
External training providers used and effective: tertiary education providers that award formal New Zealand qualifications - did not use: 21720
External training providers used and effective: tertiary education providers that award formal New Zealand qualifications - effective: 16290
External training providers used and effective: tertiary education providers that award formal New Zealand qualifications - not effective: 471
Impact of recruitment difficulties on business performance: don't know: 1491
Impact of recruitment difficulties on business performance: moderate impact: 16965
Impact of recruitment difficulties on business performance: no impact: 7041
Impact of recruitment difficulties on business performance: significant impact: 4710
Number of vacancies for all other occupations: 291675
Number of vacancies for managers and professionals: 61431
Number of vacancies for technicians and associate professionals: 51717
Number of vacancies for tradespersons and related workers (including apprentices): 108867
Percentage of employees receiving training provided or funded by business: 1-25%: 16962
Percentage of employees receiving training provided or funded by business: 100%: 8295
Percentage of employees receiving training provided or funded by business: 26-50%: 10227
Percentage of employees receiving training provided or funded by business: 51-75%: 6492
Percentage of employees receiving training provided or funded by business: 76-99%: 7050
Percentage of employees receiving training provided or funded by business: Zero: 6981
Recruitment difficulties caused business to delay developing certain goods or services: 5229
Recruitment difficulties caused business to experience increased operating costs: 9591
Recruitment difficulties caused business to experience none of the above: 10254
Recruitment difficulties caused business to have difficulties meeting quality standards or customer service objectives: 11718
Recruitment difficulties caused business to have difficulty introducing new technologies or working practices: 4290
Recruitment difficulties caused business to lose business or orders to competitors: 5481
Recruitment difficulties caused business to withdraw from offering certain goods or services: 3309
Restrictions on training employees: concern that trained employees will leave or be poached - did not restrict: 32847
Restrictions on training employees: concern that trained employees will leave or be poached - high degree: 3327
Restrictions on training employees: concern that trained employees will leave or be poached - low degree: 10938
Restrictions on training employees: concern that trained employees will leave or be poached - medium degree: 4740
Restrictions on training employees: constraints on giving employees time off - did not restrict: 19242
Restrictions on training employees: constraints on giving employees time off - high degree: 8289
Restrictions on training employees: constraints on giving employees time off - low degree: 13023
Restrictions on training employees: constraints on giving employees time off - medium degree: 13221
Restrictions on training employees: cost of training courses - did not restrict: 25902
Restrictions on training employees: cost of training courses - high degree: 5499
Restrictions on training employees: cost of training courses - low degree: 12378
Restrictions on training employees: cost of training courses - medium degree: 9996
Restrictions on training employees: lack of information on the type of training most needed - did not restrict: 34065
Restrictions on training employees: lack of information on the type of training most needed - high degree: 1452
Restrictions on training employees: lack of information on the type of training most needed - low degree: 11709
Restrictions on training employees: lack of information on the type of training most needed - medium degree: 4959
Restrictions on training employees: lack of interest from staff - did not restrict: 29409
Restrictions on training employees: lack of interest from staff - high degree: 2358
Restrictions on training employees: lack of interest from staff - low degree: 14679
Restrictions on training employees: lack of interest from staff - medium degree: 6567
Restrictions on training employees: lack of management time to organise training - did not restrict: 28182
Restrictions on training employees: lack of management time to organise training - high degree: 2994
Restrictions on training employees: lack of management time to organise training - low degree: 13317
Restrictions on training employees: lack of management time to organise training -medium degree: 7842
Restrictions on training employees: lack of suitable courses or training providers - did not restrict: 26346
Restrictions on training employees: lack of suitable courses or training providers - high degree: 4089
Restrictions on training employees: lack of suitable courses or training providers - low degree: 13182
Restrictions on training employees: lack of suitable courses or training providers - medium degree: 8910
Restrictions on training employees: uncertainty over whether training would make a difference - did not restrict: 28629
Restrictions on training employees: uncertainty over whether training would make a difference - high degree: 3039
Restrictions on training employees: uncertainty over whether training would make a difference - low degree: 13731
Restrictions on training employees: uncertainty over whether training would make a difference - medium degree: 7266
Skills from job applicants: Computer skills - skills difficult to obtain: 4707
Skills from job applicants: Computer skills - skills not difficult to obtain: 21528
Skills from job applicants: Computer skills - skills not required: 16563
Skills from job applicants: Customer service / sales skills - skills difficult to obtain: 8355
Skills from job applicants: Customer service / sales skills - skills not difficult to obtain: 19176
Skills from job applicants: Customer service / sales skills - skills not required: 15264
Skills from job applicants: Management / supervisory skills - skills difficult to obtain: 11004
Skills from job applicants: Management / supervisory skills - skills not difficult to obtain: 12102
Skills from job applicants: Management / supervisory skills - skills not required: 19677
Skills from job applicants: Marketing skills - skills difficult to obtain: 4608
Skills from job applicants: Marketing skills - skills not difficult to obtain: 10761
Skills from job applicants: Marketing skills - skills not required: 27429
Skills from job applicants: Numeracy skills (eg ability to use numbers and measures) - skills difficult to obtain: 6528
Skills from job applicants: Numeracy skills (eg ability to use numbers and measures) - skills not difficult to obtain: 25938
Skills from job applicants: Numeracy skills (eg ability to use numbers and measures) - skills not required: 10302
Skills from job applicants: Oral communication skills - skills difficult to obtain: 7536
Skills from job applicants: Oral communication skills - skills not difficult to obtain: 27192
Skills from job applicants: Oral communication skills - skills not required: 8076
Skills from job applicants: Professional / technical skills - skills difficult to obtain: 13884
Skills from job applicants: Professional / technical skills - skills not difficult to obtain: 10599
Skills from job applicants: Professional / technical skills - skills not required: 18294
Skills from job applicants: Team working skills - skills difficult to obtain: 7092
Skills from job applicants: Team working skills - skills not difficult to obtain: 29397
Skills from job applicants: Team working skills - skills not required: 6318
Skills from job applicants: Written communication skills - skills difficult to obtain: 7479
Skills from job applicants: Written communication skills - skills not difficult to obtain: 23679
Skills from job applicants: Written communication skills - skills not required: 11628
Total expenditure on training: 22823187
 */
