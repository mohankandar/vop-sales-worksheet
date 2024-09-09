package com.wynd.vop.sales.worksheet.service;

import com.wynd.vop.sales.worksheet.model.PresetPkgRequest;
import com.wynd.vop.sales.worksheet.model.PresetPackageResponse;
import com.wynd.vop.sales.worksheet.model.SampleDomainRequest;
import com.wynd.vop.sales.worksheet.model.SampleDomainResponse;

import java.util.List;

/**
 * The contract interface for the service layer.
 */
public interface WorksheetService {
  /**
   * Search for the sample info by their Participant ID.
   *
   * @param sampleDomainRequest A SampleDomainRequest instance
   * @return A SampleDomainResponse instance
   */
  SampleDomainResponse sampleFindByParticipantId(SampleDomainRequest sampleDomainRequest);

  /**
   * Retrieves the Sales Preset Package Inventory based on the given site ID and entity ID.
   *
   * @param domainRequest the request object containing the site ID and entity ID.
   * @return the Sales Preset Package Inventory matching the provided site ID and entity ID.
   */
  List<PresetPackageResponse> presetPackagesBySiteIdAndEntityId(PresetPkgRequest domainRequest);
}
