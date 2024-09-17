package com.gsamtechnology.sangiorgio.config.component;

import com.gsamtechnology.sangiorgio.adapter.in.ChargeMapper;
import com.gsamtechnology.sangiorgio.domain.usecases.ChargeUseCase;
import com.gsamtechnology.sangiorgio.ports.out.FindChargePortOut;
import com.gsamtechnology.sangiorgio.ports.out.PublishMessagePortOut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ChargeComponent {
  @Bean
  public ChargeUseCase createCharge(FindChargePortOut findChargePortOut, PublishMessagePortOut publishMessagePortOut, ChargeMapper chargeMapper){
    return new ChargeUseCase(findChargePortOut, publishMessagePortOut, chargeMapper);
  }
}
