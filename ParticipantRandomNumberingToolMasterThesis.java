import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/**
 * 硕士论文实验参与人员随机抽取编号程序
 * 1. 支持用户输入筛选目标数量，若输入非正整数则提示错误并要求重新输入
 * 2. 支持用户输入多个员工编号，使用英文逗号分隔，程序会自动清洗数据（去除空格和空值）
 * 3. 程序会随机打乱有效编号列表，并按目标数量筛选出结果，保证每次运行结果不同
 * 4. 输出有效编号总数、实际筛选数量以及随机抽取的员工编号列表
 * 5. 若用户未输入有效编号或筛选数量为0，则提示错误并退出程序
 */
public class ParticipantRandomNumberingToolMasterThesis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 读取并校验筛选目标数量（支持错误重输）
        int targetCount = 0;
        while (true) {
            System.out.print("请输入筛选的目标数量：");
            String countInput = scanner.nextLine().trim();

            try {
                targetCount = Integer.parseInt(countInput);
                if (targetCount <= 0) {
                    System.out.println("数量必须大于0，请重新输入！\n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入格式错误，请输入有效的整数数字！\n");
            }
        }

        // 2. 读取员工编号输入
        System.out.println("\n请输入员工编号，多个编号以英文逗号分隔：");
        String inputContent = "";
        if (scanner.hasNextLine()) {
            inputContent = scanner.nextLine();
        } else {
            System.out.println("未检测到有效输入，程序退出！");
            scanner.close();
            return;
        }
        scanner.close();

        // 3. 清洗数据：分割、去空格、过滤空值
        List<String> validIdList = Arrays.stream(inputContent.split(","))
                .map(String::trim)
                .filter(id -> !id.isEmpty())
                .collect(Collectors.toList());

        if (validIdList.isEmpty()) {
            System.out.println("\n未识别到有效的员工编号！");
            return;
        }

        // 4. 随机打乱后按目标数量筛选（核心修改点）
        List<String> shuffledList = new ArrayList<>(validIdList);
        Collections.shuffle(shuffledList); // 随机打乱顺序，每次运行结果不同

        int endIndex = Math.min(shuffledList.size(), targetCount);
        List<String> resultList = shuffledList.subList(0, endIndex);

        // 5. 输出结果
        System.out.println("\n===== 随机筛选结果 =====");
        System.out.println("输入有效编号总数：" + validIdList.size());
        System.out.println("实际筛选数量：" + resultList.size());
        System.out.println("随机抽取的员工编号：");
        for (int i = 0; i < resultList.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, resultList.get(i));
        }
    }
}