package hello.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.List;
import java.util.Set;

@Slf4j
public class CommandLineV2 {

    public static void main(String[] args) {
        // --url=dev_db --username=dev_user --password=dev_pw mode=on
        for (String arg : args) {
            log.info("arg = {}", arg);
        }

        //스프링에서 제공하는 환경변수 라이브러리
        ApplicationArguments appArgs = new DefaultApplicationArguments(args);
        log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs()));
        log.info("NonOptionsArgs = {}", appArgs.getNonOptionArgs());
        log.info("OptionsNames = {}", appArgs.getOptionNames());


        Set<String> optionNames = appArgs.getOptionNames();
        for (String optionName : optionNames) {
            log.info("options arg{}={}", optionName, appArgs.getOptionValues(optionName));
        }

        List<String> url = appArgs.getOptionValues("url");
        List<String> username = appArgs.getOptionValues("username");
        List<String> password = appArgs.getOptionValues("password");
        List<String> mode = appArgs.getOptionValues("mode");

        log.info("url = {}" , url);
        log.info("username = {}" , username);
        log.info("password = {}" , password);
        log.info("mode = {}" , mode);

    }


}
